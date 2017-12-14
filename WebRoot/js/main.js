;$(function()
{
	'use strict';
	
	var sidebar = $('#sidebar'),//选择侧栏
	      mask = $('.mask'),//选择mask
	      backButtom = $('.back-to-top'),//选择返回菜单
	      sidebar_trigger = $('#sidebar_trigger');//选择侧栏触发器
	     
	function showSideBar()    //显示侧栏
	{
		mask.fadeIn();       //显示mask
		/*sidebar.animate({'right':0});*/
		sidebar.css('right',0);
	}
	
	function hideSideBar()   //隐藏侧栏
	{
		mask.fadeOut();
		sidebar.css('right',-sidebar.width());
	}
	
	sidebar_trigger.on('click',showSideBar)
	mask.on('click',hideSideBar)
	
	backButtom.on('click',function()    
	{
		$('html,body').animate({
			scrollTop:0
		},800)
	})
	
	$(window).on('scroll',function()
	{
		if($(window).scrollTop()>$(window).height())
		{
			backButtom.fadeIn();
		}
		else
		{
			backButtom.fadeOut();
		}
	})
	
	$(window).trigger('scroll');
	
})

