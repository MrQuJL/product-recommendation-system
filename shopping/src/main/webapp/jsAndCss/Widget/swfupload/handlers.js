/* Demo Note:  This demo uses a FileProgress class that handles the UI for displaying the file name and percent complete.
The FileProgress class is not part of SWFUpload.
*/


/* **********************
   Event Handlers
   These are my custom event handlers to make my
   web application behave the way I went when SWFUpload
   completes different tasks.  These aren't part of the SWFUpload
   package.  They are part of my application.  Without these none
   of the actions SWFUpload makes will show up in my application.
   ********************** */
function preLoad() {
	if (!this.support.loading) {
		alert("你需要安装Flash Player 9.028或者更高版本，才能使用上传功能。");
		return false;
	}
}
function loadFailed() {
	alert("装在上传组件失败，请重新刷新页面重试。");
}

function fileQueued(file) {
	try {
		if(this.customSettings.tdFilesQueued != undefined) {
			this.customSettings.tdFilesQueued.innerHTML = this.getStats().files_queued;
		}
	} catch (ex) {
		this.debug(ex);
	}

}

function fileDialogComplete() {
	this.startUpload();
}

function uploadStart(file) {
	try {
		if(this.customSettings.progressCount != undefined) {
			this.customSettings.progressCount = 0;
		}
		updateDisplay.call(this, file);
	}
	catch (ex) {
		this.debug(ex);
	}
	
}

function uploadProgress(file, bytesLoaded, bytesTotal) {
	try {
		if(this.customSettings.progressCount != undefined) {
			this.customSettings.progressCount++;
		}
		updateDisplay.call(this, file);
	} catch (ex) {
		this.debug(ex);
	}
	
}

function uploadSuccess(file, serverData) {
	try {
		updateDisplay.call(this, file);
	} catch (ex) {
		this.debug(ex);
	}
}

function uploadComplete(file) {
	if(this.customSettings.tdFilesQueued != undefined) {
		this.customSettings.tdFilesQueued.innerHTML = this.getStats().files_queued;
	}
	if(this.customSettings.tdFilesUploaded != undefined) {
		this.customSettings.tdFilesUploaded.innerHTML = this.getStats().successful_uploads;
	}
	if(this.customSettings.tdErrors != undefined) {
		this.customSettings.tdErrors.innerHTML = this.getStats().upload_errors;
	}
}

function updateDisplay(file) {
	if(this.customSettings.tdCurrentSpeed != undefined) {
		this.customSettings.tdCurrentSpeed.innerHTML = SWFUpload.speed.formatBPS(file.currentSpeed);
	}
	if(this.customSettings.tdAverageSpeed != undefined) {
		this.customSettings.tdAverageSpeed.innerHTML = SWFUpload.speed.formatBPS(file.averageSpeed);
	}
	if(this.customSettings.tdMovingAverageSpeed != undefined) {
		this.customSettings.tdMovingAverageSpeed.innerHTML = SWFUpload.speed.formatBPS(file.movingAverageSpeed);
	}
	if(this.customSettings.tdTimeRemaining != undefined) {
		this.customSettings.tdTimeRemaining.innerHTML = SWFUpload.speed.formatTime(file.timeRemaining);
	}
	if(this.customSettings.tdTimeElapsed != undefined) {
		this.customSettings.tdTimeElapsed.innerHTML = SWFUpload.speed.formatTime(file.timeElapsed);
	}
	if(this.customSettings.tdPercentUploaded != undefined) {
		this.customSettings.tdPercentUploaded.innerHTML = SWFUpload.speed.formatPercent(file.percentUploaded);
	}
	if(this.customSettings.tdSizeUploaded != undefined) {
		this.customSettings.tdSizeUploaded.innerHTML = SWFUpload.speed.formatBytes(file.sizeUploaded);
	}
	if(this.customSettings.tdProgressEventCount != undefined) {
		this.customSettings.tdProgressEventCount.innerHTML = this.customSettings.progressCount;
	}
}