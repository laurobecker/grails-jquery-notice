modules = {
	'jquery-notice' {
		dependsOn 'jquery'
		resource url: [plugin : 'jquery-notice', dir : 'css', file : 'jquery.notice.css'], nominify: true
		resource url: [plugin : 'jquery-notice', dir : 'js', file : 'jquery.notice.js'], nominify: true
	}
	
	'jquery-notice-all' {
		dependsOn 'jquery-notice'
		resource url: [plugin : 'jquery-notice', dir : 'css', file : 'jquery.notice.fix.css'], nominify: true
	}
}