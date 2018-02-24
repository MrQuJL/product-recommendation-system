<?php
	
	$upload_file = $_FILES["Filedata"];
	
	// 验证上传
	if (!isset($upload_file)) {
		HandleError("没有找到上传文件。");
		exit(0);
	} else if (isset($upload_file["error"]) && $upload_file["error"] != 0) {
		HandleError($uploadErrors[$uploadErrors["error"]]);
		exit(0);
	} else if (!isset($upload_file["tmp_name"]) || !@is_uploaded_file($upload_file["tmp_name"])) {
		HandleError("上传失败is_uploaded_file测试。");
		exit(0);
	} else if (!isset($upload_file['name'])) {
		HandleError("文件还没有名字。");
		exit(0);
	}

	// 设置
	$save_path = "upload/"; // 存储路径
	$max_file_size_in_bytes = 2*1024*1024*1024;// 2GB in bytes
	$extension_whitelist = array("jpg", "gif", "png", "flv", "f4v", "mp4");	// 允许的文件类型
	
	// 其他参数	
	$file_name = md5(uniqid($_FILES[$upload_name]['name'])); // 生成唯一的文件名
	$file_extension = "";
	
	
	// 验证上传文件的文件大小（注意：此代码支持的最大文件为2GB）
	$file_size = @filesize($upload_file["tmp_name"]);
	if (!$file_size || $file_size > $max_file_size_in_bytes) {
		HandleError("文件超过允许的最大大小。");
		exit(0);
	}
	if ($file_size <= 0) {
		HandleError("文件大小为0。");
		exit(0);
	}

	// 验证文件扩展名
	$path_info = pathinfo($upload_file['name']);
	$file_extension = $path_info["extension"];
	$is_valid_extension = false;
	foreach ($extension_whitelist as $extension) {
		if (strcasecmp($file_extension, $extension) == 0) {
			$is_valid_extension = true;
			break;
		}
	}
	if (!$is_valid_extension) {
		HandleError("无效的文件扩展名。");
		exit(0);
	}
	$file_full_path = $save_path . $file_name . "." . $file_extension;
	// 移动文件
	if (!@move_uploaded_file($upload_file["tmp_name"], $file_full_path)) {
		HandleError("文件没有被保存成功。");
		exit(0);
	}
	
	if($file_extension == "jpg" || $file_extension == "png" || $file_extension == "gif" ) {
		list($up_width, $up_height, $up_type, $up_attr) = getimagesize($file_full_path);
		echo "{path:\"".$file_full_path."\", width:".$up_width.", height:".$up_height."}";
	} else {
		// 输出文件名
		echo "{path:".$file_full_path."}";
	}
	exit(0);
	// 输出消息
	function HandleError($message) {
		echo $message;
	}
?>