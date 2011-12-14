package grails.plugin.jquerynotice

class FooController {
	
	/**
	 * 
	 */
	def index = {
		Foo f = new Foo();
		f.save();
		
		flash.message = "This is a Flash Message";	
		flash.error = "This is a Flash Error";
		flash.success = "This is a Flash Success";
		
		[bean: f]
	};
}
