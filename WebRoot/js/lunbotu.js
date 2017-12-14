 window.onload = function()   //轮播图js
 {
            var list = document.getElementById('list');var prev = document.getElementById('prev');
            var next = document.getElementById('next');

            function animate(offset) 
            {
                //获取的是style.left，是相对左边获取距离，所以第一张图后style.left都为负值，
                //且style.left获取的是字符串，需要用parseInt()取整转化为数字。
                var newLeft = parseInt(list.style.left) + offset;
                list.style.left = newLeft + 'px';
                 if(newLeft<-3600)
                 {
                   list.style.left = -900 + 'px';
                   }
                 if(newLeft>-900)
                 {
                   list.style.left = -3600 + 'px';
                   }
            }

            prev.onclick = function() 
            {
                animate(900);
            }
            next.onclick = function() 
            {
                animate(-900);
            }
   
             var timer;   //定时器
            function play() 
            {
              timer = setInterval(function () 
              {
              prev.onclick()
              }, 1500)
            }
            play();
          
            var container = document.getElementById('container'); //点击某张图片后，清除定时器

            function stop() {
                clearInterval(timer);
            }
            container.onmouseover = stop;
            container.onmouseout = play;
   
   
            var buttons = document.getElementById('buttons').getElementsByTagName('span');//小圆点
            var index = 1;

            function buttonsShow() {
                //这里需要清除之前的样式
                for (var i = 0; i < buttons.length; i++) {
                    if (buttons[i].className == 'on') {
                        buttons[i].className = '';
                    }
                }
                //数组从0开始，故index需要-1
                buttons[index - 1].className = 'on';
            }

            prev.onclick = function() {
                index -= 1;
                if (index < 1) {
                    index = 5;
                }
                buttonsShow();
                animate(900);
            }
            next.onclick = function() {
                //由于上边定时器的作用，index会一直递增下去，我们只有5个小圆点，所以需要做出判断
                index += 1;
                if (index > 5) {
                    index = 1;
                }
                buttonsShow();
                animate(-900);
            }
            
            for (var i = 0; i < buttons.length; i++) {
                // 这里使用的是立即执行函数，
                (function(i) {
                    buttons[i].onclick = function() {
                        var clickIndex = parseInt(this.getAttribute('index'));
                        var offset = 900 * (index - clickIndex); 
                        animate(offset);
                        index = clickIndex;
                        buttonsShow();
                    }
                })(i)
            }
}
 
