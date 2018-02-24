var DataSourceTree = function(options) {
	this._data 	= options.data;
	this._delay = options.delay;
}

DataSourceTree.prototype.data = function(options, callback) {
	var self = this;
	var $data = null;

	if(!("name" in options) && !("type" in options)){
		$data = this._data;//the root tree
		callback({ data: $data });
		return;
	}
	else if("type" in options && options.type == "folder") {
		if("additionalParameters" in options && "children" in options.additionalParameters)
			$data = options.additionalParameters.children;
		else $data = {}//no data
	}
	
	if($data != null)//this setTimeout is only for mimicking some random delay
		setTimeout(function(){callback({ data: $data });} , parseInt(Math.random() * 500) + 200);

	//we have used static data here
	//but you can retrieve your data dynamically from a server using ajax call
	//checkout examples/treeview.html and examples/treeview.js for more info
};

var tree_data = {
	'for-sale' : {name: 'For Sale', type: 'folder'}	,
	'vehicles' : {name: 'Vehicles', type: 'folder'}	,
	'rentals' : {name: 'Rentals', type: 'folder'}	,
	'real-estate' : {name: 'Real Estate', type: 'folder'}	,
	'pets' : {name: 'Pets', type: 'folder'}	,
	'tickets' : {name: 'Tickets', type: 'item'}	,
	'services' : {name: 'Services', type: 'item'}	,
	'personals' : {name: 'Personals', type: 'item'}
}
tree_data['for-sale']['additionalParameters'] = {
	'children' : {
		'appliances' : {name: 'Appliances', type: 'item'},
		'arts-crafts' : {name: 'Arts & Crafts', type: 'item'},
		'clothing' : {name: 'Clothing', type: 'item'},
		'computers' : {name: 'Computers', type: 'item'},
		'jewelry' : {name: 'Jewelry', type: 'item'},
		'office-business' : {name: 'Office & Business', type: 'item'},
		'sports-fitness' : {name: 'Sports & Fitness', type: 'item'}
	}
}
tree_data['vehicles']['additionalParameters'] = {
	'children' : {
		'cars' : {name: 'Cars', type: 'folder'},
		'motorcycles' : {name: 'Motorcycles', type: 'item'},
		'boats' : {name: 'Boats', type: 'item'}
	}
}
tree_data['vehicles']['additionalParameters']['children']['cars']['additionalParameters'] = {
	'children' : {
		'classics' : {name: 'Classics', type: 'item'},
		'convertibles' : {name: 'Convertibles', type: 'item'},
		'coupes' : {name: 'Coupes', type: 'item'},
		'hatchbacks' : {name: 'Hatchbacks', type: 'item'},
		'hybrids' : {name: 'Hybrids', type: 'item'},
		'suvs' : {name: 'SUVs', type: 'item'},
		'sedans' : {name: 'Sedans', type: 'item'},
		'trucks' : {name: 'Trucks', type: 'item'}
	}
}

tree_data['rentals']['additionalParameters'] = {
	'children' : {
		'apartments-rentals' : {name: 'Apartments', type: 'item'},
		'office-space-rentals' : {name: 'Office Space', type: 'item'},
		'vacation-rentals' : {name: 'Vacation Rentals', type: 'item'}
	}
}
tree_data['real-estate']['additionalParameters'] = {
	'children' : {
		'apartments' : {name: 'Apartments', type: 'item'},
		'villas' : {name: 'Villas', type: 'item'},
		'plots' : {name: 'Plots', type: 'item'}
	}
}
tree_data['pets']['additionalParameters'] = {
	'children' : {
		'cats' : {name: 'Cats', type: 'item'},
		'dogs' : {name: 'Dogs', type: 'item'},
		'horses' : {name: 'Horses', type: 'item'},
		'reptiles' : {name: 'Reptiles', type: 'item'}
	}
}

var treeDataSource = new DataSourceTree({data: tree_data});











var tree_data_2 = {
	'1' : {name: '水果蔬菜', type: 'folder', 'icon-class':'orange'}	,
	'2' : {name: '大家电', type: 'folder', 'icon-class':'orange'}	,
	'3' : {name: '小电器', type: 'folder', 'icon-class':'orange'}	,
	'4' : {name: '手机数码', type: 'folder', 'icon-class':'orange'}	,
	'5' : {name: '服装鞋帽', type: 'folder', 'icon-class':'orange'}	,
	'6' : {name: '粮油副食', type: 'folder', 'icon-class':'orange'}	,
	'7' : {name: '零食', type: 'folder', 'icon-class':'orange'}	,
	'8' : {name: '卫浴', type: 'folder', 'icon-class':'orange'}	,
	'9' : {name: '厨房用具', type: 'orange'}	,
}
tree_data_2['1']['additionalParameters'] = {
	'children' : [
		{name: '<a href=""><i class="icon-file-text blue"></i>苹果</a>', type: 'item'},
		{name: '<i class="icon-file-text blue"></i> song2.ogg', type: 'item'},
		{name: '<i class="icon-file-text blue"></i> song3.ogg', type: 'item'},
		{name: '<i class="icon-file-text blue"></i> song4.ogg', type: 'item'},
		{name: '<i class="icon-file-text blue"></i> song5.ogg', type: 'item'}
	]
}
tree_data_2['2']['additionalParameters'] = {
	'children' : [
		{name: '<i class="icon-file-text blue"></i> movie1.avi', type: 'item'},
		{name: '<i class="icon-file-text blue"></i> movie2.avi', type: 'item'},
		{name: '<i class="icon-file-text blue"></i> movie3.avi', type: 'item'},
		{name: '<i class="icon-file-text blue"></i> movie4.avi', type: 'item'},
		{name: '<i class="icon-file-text blue"></i> movie5.avi', type: 'item'}
	]
}
tree_data_2['3']['additionalParameters'] = {
	'children' : {
		'wallpapers' : {name: 'Wallpapers', type: 'folder', 'icon-class':'pink'},
		'camera' : {name: 'Camera', type: 'folder', 'icon-class':'pink'}
	}
}
tree_data_2['3']['additionalParameters']['children']['wallpapers']['additionalParameters'] = {
	'children' : [
		{name: '<i class="icon-file-text green"></i> wallpaper1.jpg', type: 'item'},
		{name: '<i class="icon-file-text green"></i> wallpaper2.jpg', type: 'item'},
		{name: '<i class="icon-file-text green"></i> wallpaper3.jpg', type: 'item'},
		{name: '<i class="icon-file-text green"></i> wallpaper4.jpg', type: 'item'}
	]
}
tree_data_2['3']['additionalParameters']['children']['camera']['additionalParameters'] = {
	'children' : [
		{name: '<i class="icon-file-text green"></i> photo1.jpg', type: 'item'},
		{name: '<i class="icon-file-text green"></i> photo2.jpg', type: 'item'},
		{name: '<i class="icon-file-text green"></i> photo3.jpg', type: 'item'},
		{name: '<i class="icon-file-text green"></i> photo4.jpg', type: 'item'},
		{name: '<i class="icon-file-text green"></i> photo5.jpg', type: 'item'},
		{name: '<i class="icon-file-text green"></i> photo6.jpg', type: 'item'}
	]
}


tree_data_2['4']['additionalParameters'] = {
	'children' : [
		{name: '<i class="icon-file-text red"></i> document1.pdf', type: 'item'},
		{name: '<i class="icon-file-text grey"></i> document2.doc', type: 'item'},
		{name: '<i class="icon-file-text grey"></i> document3.doc', type: 'item'},
		{name: '<i class="icon-file-text red"></i> document4.pdf', type: 'item'},
		{name: '<i class="icon-file-text grey"></i> document5.doc', type: 'item'}
	]
}

tree_data_2['5']['additionalParameters'] = {
	'children' : [
		{name: '<i class="icon-file-text brown"></i> backup1.zip', type: 'item'},
		{name: '<i class="icon-file-text brown"></i> backup2.zip', type: 'item'},
		{name: '<i class="icon-file-text brown"></i> backup3.zip', type: 'item'},
		{name: '<i class="icon-file-text brown"></i> backup4.zip', type: 'item'}
	]
}
var treeDataSource2 = new DataSourceTree({data: tree_data_2});