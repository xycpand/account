        //cookie失效时间
        var x_expire = 60 * 30;
       //js接口的根路径 
        var x_rootPath = "http://localhost:6060/if";
	    /**
		 * 动态加载js
		 */
		var loadJS = function( id, fileUrl ) 
		{ 
	    	var oHead = document.getElementsByTagName('head').item(0); 
	    	var scriptTag = document.getElementById( id ); 
	    	if (scriptTag) oHead.removeChild(scriptTag); 
	    	var oScript= document.createElement("script"); 
	    	oScript.id = id; 
	    	oScript.language = "javascript"; 
	    	oScript.type = "text/javascript";
	    	oScript.src=fileUrl ; 
	    	oScript.onload = oScript.onreadystatechange = function() { 
	    		if (!this.readyState || this.readyState === "loaded" || this.readyState === "complete" ) { 
	    			if(id == "userinfo"){
    		    	  //保存微信用户信息后，再保存 阅读记录
    		    	  saveReadOrShareRecord();
    		        }
	    			// Handle memory leak in IE 
	    		    oScript.onload = oScript.onreadystatechange = null; 
	    		} 
			}; 
	    	oHead.appendChild(oScript); 
	    	console.log("成功加载"+id+".js:"+fileUrl);
		}; 
		
		/**
		 * 获取项目根路径
		 */
		var getRootPath =  function(){
	   	    var curWwwPath=window.document.location.href;
	   	    var pathName=window.document.location.pathname;
	   	    var pos=curWwwPath.indexOf(pathName);
	   	    var localhostPaht=curWwwPath.substring(0,pos);
	   	    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	   	    return(localhostPaht+projectName);
	   	};
	    
		/**
		 * 获取上下文路径
		 */
		var getContextPath = function() {
		    var pathName = document.location.pathname;
		    var index = pathName.substr(1).indexOf("/");
		    var result = pathName.substr(0,index+1);
		    return result;
		};

		
		//获取http协议中的url
		var getUrlFromHttp = function(e) {
			var t = /http:\/\/([^\/]+)\//i;
			var n = e.match(t);
			return n[1];
		};

		
		var getDomain = function(e) {
			if (!e) return "";
			if (e.indexOf("://") != -1) e = e.substr(e.indexOf("://") + 3);
			var t = ["com", "net", "org", "gov", "edu", "mil", "biz", "name", "info", "mobi", "pro", "travel", "museum", "int", "areo", "post", "rec", "im", "cn", "me"];
			var n = e.split(".");
			if (n.length <= 1) return e;
			if (!isNaN(n[n.length - 1])) return e;
			var r = ".com.cn";
			if (e.indexOf(r) != -1) {
				return n[n.length - 3] + "." + n[n.length - 2] + "." + n[n.length - 1]
			}
			var i = 0;
			while (i < t.length && t[i] != n[n.length - 1]) i++;
			if (i != t.length) return n[n.length - 2] + "." + n[n.length - 1];
			else {
				i = 0;
				while (i < t.length && t[i] != n[n.length - 2]) i++;
				if (i == t.length) return n[n.length - 2] + "." + n[n.length - 1];
				else return n[n.length - 3] + "." + n[n.length - 2] + "." + n[n.length - 1]
			}
		};

		//cookie 内容管理
		var cookieManager = {
			get: function(e) {
				var t = document.cookie.match(new RegExp("(^| )" + e + "=([^;] * )(; | $)"));
				if (t != null) return unescape(t[2]);
				return null
			},
			add: function(e, t, n) {
				var i = e + "=" + t;
				if (n != 0) {
					var date = new Date;
					var a = n * 1e3;
					date.setTime(date.getTime() + a);
					i +=  ";expires = "+date.toGMTString()
				}
				var s = getDomain(location.hostname);
					if (s != "") {
						i += ";domain = "+s
					}
					i+=";path = /";
					document.cookie = i
			}
		};



				var o = function(){
					var t = {
						setItem: function(t, n) {
							cookieManager.add(t, n, x_expire)
						},
						getItem: function(t) {
							return cookieManager.get(t)
						},
						removeItem: function(t) {
							cookieManager.add(t, "", -1)
						}
					};
					if (sessionStorage) {
						try {
							var o = ["x_reader", "x_articleId", "x_originalUrl"];
							var a = function() {
								if (document.referrer != "") {
									//document.referrer 返回导航到当前网页的超链接所在网页的URL
									var e = getDomain(n(document.referrer));
									var t = getDomain(location.hostname);
									return e == t
								} else {
									return false
								}
							}();
							if (!a) {
								for (var s = 0; s < o.length; s++) {
									t.removeItem(o[s])
								}
							} else {
								for (var s = 0; s < o.length; s++) {
									var c = sessionStorage.getItem(o[s]);
									var u = t.getItem(o[s]);
									if ((c == null || c == "") && (u != null && u != "")) {
										sessionStorage.setItem(o[s], u)
									}
								}
							}
						} catch (f) {}
					}
					return {
						setItem: function(e, n) {
							sessionStorage && sessionStorage.setItem(e, n);
							t.setItem(e, n)
						},
						getItem: function(e) {
							if (sessionStorage) {
								return sessionStorage.getItem(e)
							} else {
								return t.getItem(e)
							}
						}
					}
				}();
				
				/**
				 * 获取 当前URL 指定参数的值
				 */
				var getUrlParam = function(name) {
					var t = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
					var curUrl = window.location.search.substr(1).replace(/&amp;/g, "&");
					var n = curUrl.match(t);
					if (n != null) return unescape(n[2]);
					return null
				};
				
				/**
				 * 获取 查询串 中指定参数名称的值
				 * @param name
				 * @returns
				 */
				var getQueryString = function(queryStr,name){
					 queryStr = queryStr.replace(/&amp;/g, "&");
					 var re=eval('/('+ name+'=)([^&]*)/gi');
				     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
				     var r = queryStr.match(reg);
				     if(r!=null)return  unescape(r[2]); return null;
				}
				
				/**
				 *  替换URL中指定的参数值
				 */
				var replaceParamVal = function(oldUrl,paramName,replaceWith) {
					  if(oldUrl.indexOf(paramName) == -1){
						 //url中没有该名称的参数，则进行添加
						  if(oldUrl.indexOf("?") == -1){
							  oldUrl += "?"+paramName+"="+replaceWith;
						  }else{
							  oldUrl += "&"+paramName+"="+replaceWith;
						  }
					  }else{
						  //url中已经有该名称的参数，则将相应的值替换
						  var re=eval('/('+ paramName+'=)([^&]*)/gi');
						  oldUrl = oldUrl.replace(re,paramName+'='+replaceWith);
					  }
				   return oldUrl;
				}	
				
				

         /**
		 * shareUrl后面添加articleId,originalOpenId参数
		 * 其中originalOpenId为cookie中的x_reader 
		 */
		var add4share = function(shareUrl){
			  if(!shareUrl){
			     shareUrl = window.location.href;
			  }
			  shareUrl = shareUrl.replace(/&amp;/g, "&");
			 if(shareUrl){
				  var articleId = o.getItem("x_articleId");
				  //originalOpenId为cookie中的x_reader 
				  var originalOpenId = o.getItem("x_reader");
				  //参数加上文章id
				  shareUrl = replaceParamVal(shareUrl,"x_articleId",articleId);

				  //参数加上分享者openId
				  shareUrl = replaceParamVal(shareUrl,"x_sharer",originalOpenId);
			 }
			 return shareUrl;
		  }; 
	  
	   	  
	        /**
			 * 保存阅读记录和分享记录
			 */
		  var saveReadOrShareRecord = function(){
		      //阅读者id
		      //var openId = getUrlParam('x_reader');
			  var openId = o.getItem("x_reader");
			  console.log("saveReadOrShareRecord方法从缓存中取出x_reader:"+ openId);

			  var articleId = o.getItem("x_articleId");
			  console.log("saveReadOrShareRecord方法从缓存中取出x_articleId:"+ articleId);
			  
		  	  if(openId && articleId){
		  		   //阅读时的链接
			        var originalUrl =encodeURIComponent(window.location.href);
			        //分享者用户id
			        var originalOpenId =  getUrlParam('x_sharer');

			        // alert("originalOpenId:"+originalOpenId);
			        // alert("openId:"+openId);
			        // alert("articleId:"+articleId);
			        // 分享类型
			        var shareType ; 
			        // 分享目标
			        var shareTarget ;      
			  	  //缓存参数：把链接url,文章id保存到cookie中
				   o.setItem('x_originalUrl', originalUrl); 
				   o.setItem('x_articleId', articleId); 

			   	  console.log("userid:"+o.getItem("x_reader"));
			  	  console.log("articleId:"+o.getItem("x_articleId"));
			   	  console.log("originalUrl:"+o.getItem("x_originalUrl")); 
			  	  console.log("getRootPath:"+x_rootPath);
		  		     //加载userread.js，保存“阅读记录”
				  	 var jsUrl = x_rootPath+"/userRecord/userread.js?openId="+openId+"&articleId="+articleId;
			  		     if(originalOpenId){
				  			jsUrl+="&originalOpenId="+originalOpenId;
				  		 }
				  		 if(originalUrl){
					  		jsUrl+="&originalUrl="+originalUrl;
					  	 }
				  		 loadJS("userread",jsUrl);
				   	  /**
				   	   * 从url中提取originalUserid参数，如果存在则保存"分享记录"
				   	   */
				  	 /* if(originalOpenId){
				  		 var userappendJSUrl = x_rootPath+"/userRecord/userappend.js?openId="+openId
				  		 +"&articleId="+articleId+"&originalOpenId="+originalOpenId;
				  		 if(originalUrl){
				  			userappendJSUrl+="&originalUrl="+originalUrl;
				  		 }
				  		 console.log("动态加载userappend.js:"+userappendJSUrl);
				  		 loadJS("userappend",userappendJSUrl);
				  		 alert("加载了userappend.js");
				  	  }*/
		  	  }
		  };//end of saveReadOrShareRecord
		  
		  /**
			* 保存分享记录
			*/
		  var saveShareRecord = function(shareParam){
				  	if(shareParam){
				  		 //加载save_share.js，保存“阅读记录”
					      var saveShareUrl = x_rootPath+"/userRecord/save_share.js";
						  if(shareParam.indexOf("?") == -1){
							  shareParam = "?" + shareParam;
						  }
						  saveShareUrl += shareParam;
						  console.log("save_share.js:"+saveShareUrl);
						  loadJS("save_share",saveShareUrl);
					 }
		  };
		  
		  
		  /**
		   * 保存微信用户信息
		   */
		  var sendUserInfo =  function(userinfoParam){
			  if(userinfoParam){
				  var x_reader = getQueryString(userinfoParam,"openid");
				  //只有当参数中包含了openid时，才进行“保存用户信息”和“保存阅读分享记录”的操作
				  if(x_reader){
					  //缓存参数：把阅读者id保存到cookie中
					  o.setItem('x_reader',x_reader); 
					  console.log("sendUserInfo方法缓存了x_reader:"+ o.getItem('x_reader'));
					  
					  // alert("userinfoParam:"+userinfoParam);
				      var x_articleId = getUrlParam('x_articleId');
				      //缓存参数：把文章id保存到cookie中
					  o.setItem('x_articleId',x_articleId); 
					  console.log("sendUserInfo方法缓存了x_articleId:"+ o.getItem('x_articleId'));
					  
					  var userinfoJsUrl = x_rootPath+ "/userRecord/userinfo.js";
					  if(userinfoParam.indexOf("?") == -1){
						  userinfoParam = "?" + userinfoParam;
					  }
					  userinfoJsUrl += userinfoParam;
					  loadJS("userinfo",userinfoJsUrl);
				  }else{
					  alert("sendUserInfo中从参数userinfoParam中未获取到openid："+userinfoParam);
				  }
			  }
	   	  };
	   	  
	   
