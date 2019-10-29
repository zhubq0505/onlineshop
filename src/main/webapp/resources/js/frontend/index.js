$(function(){
	var url = '/onlineshop/frontend/listmainpageinfo';
	$.getJSON(url, function(data){
		if(data.success){
			var headLineList = data.headLineList;
			var swiperHtml = '';
			headLineList.map(function(item,index){
				swiperHtml += '<div class="swiper-slide img-wrap">'
					+ '<a href="' + item.lineLink + '" external>'
					+ '<img class="banner-img" src="' + item.lineImg
					+ '" alt="' + item.lineName + '></a></div>'
			});
			$('.swiper-wrapper').html(swiperHtml);
			//轮换时间：3s
			$('.swiper-contain').swiper({
				autoplay:3000,
				//用户对轮播图进行操作时，是否自动停止autoplay
				autoplayDisableOnInteration:false
			});
			//获取一级类别列表
			var shopCategoryList = data.shopCategoryList;
			var categoryHtml = '';
			shopCategoryList.map(function(item,index){
				categoryHtml += '<div class="col-50 shop-classify" data-category=' + item.shopCategoryId
					+ '><div class="word"><p class="shop-title">' + item.shopCategoryName + '</p>'
					+ '<p class="shop-desc">' + item.shopCategoryDesc + '</p></div>'
					+ '<div class="shop-classify-img-warp">' + '<img class="shop-img" src="' + item.shopCategoryImg
					+ '></div></div>';
			});
			//将拼接好的类别赋值给前端控件展示
			$('.row').html(categoryHtml);
		}
	});

	//"我的"点击事件
	$('#me').click(function(){
		$.openPanel('#panel-right-demo');
	});
	
	$('.row').on('click', 'shop-classify', function(e){
		var shopCategoryId = e.currentTarget.dataset.category;
		var newUrl = '/online/frontend/shoplist?parentId=' + shopCategoryId;
		window.location.href = newUrl;
	});
});