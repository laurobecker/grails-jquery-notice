package grails.plugin.jquerynotice

class JqueryNoticeTagLib {
	static namespace = "n";
	
	/**
	 * 
	 */
	def notice = { attrs, body ->
		attrs.text = attrs.text?: body();
		attrs.type = attrs.type?: 'notice';
		attrs.inEffect = attrs.inEffect?: '{opacity: \'show\'}';
		attrs.inEffectDuration = attrs.inEffectDuration?: 200;
		attrs.stay = attrs.stay?: 'false';
		attrs.stayTime = attrs.stayTime?: 3000;
		
		attrs.text = attrs.text?.replace("\n", "")?.replace("\t", "");
		
		out << r.script() {
			out << """
				\$.noticeAdd({
					inEffect:  ${attrs.inEffect},
					inEffectDuration: ${attrs.inEffectDuration},
					stayTime: ${attrs.stayTime},
					text: '${attrs.text}',
					stay: ${attrs.stay},
					type: '${attrs.type}'
				});
			""";	
		}
	}
	
	/**
	 * 
	 */
	def error = { attrs, body ->
		attrs.type = "notice-error";
		attrs.stay = true;
		out << n.notice(attrs, body);
	}
	
	/**
	 * 
	 */
	def success = { attrs, body ->
		attrs.type = "notice-success";
		out << n.notice(attrs, body);
	}
	
	
	/**
	 * 
	 */
	def flashMessageNotice = { attrs ->
		if (flash.message || flash.defaultMessage) {
			if (!flash.defaultMessage) {
				flash.defaultMessage = flash.message;	
			}
			
			out << n.notice(attrs) {
				out << g.message(code: flash.message, args: flash.args, default: flash.defaultMessage);	
			}
		}	
	}
	
	/**
	 * 
	 */
	def flashErrorNotice = { attrs ->
		if (flash.error || flash.defaultError) {
			if (!flash.defaultError) {
				flash.defaultError = flash.error;
			}
			
			out << n.error(attrs) {
				out << g.message(code: flash.error, args: flash.args, default: flash.defaultError);
			}
		}
	}
	
	/**
	 * 
	 */
	def flashSuccessNotice = { attrs ->
		if (flash.success || flash.defaultSuccess) {
			if (!flash.defaultSuccess) {
				flash.defaultSuccess = flash.success;
			}
			
			out << n.success(attrs) {
				out << g.message(code: flash.success, args: flash.args, default: flash.defaultSuccess);
			}
		}
	}
	
	/**
	 * 
	 */
	def renderErrorsNotice = { attrs ->
		def bean = attrs.bean;
		attrs.remove(bean);
		out << g.hasErrors(bean: bean) {
			StringBuilder errorsTxt = new StringBuilder();
			g.eachError(bean: bean) {
				errorsTxt << g.message(error: it);
				errorsTxt << "<br/>";
			}
			
			out << n.error(attrs) {
				out << errorsTxt.toString();
			}
		}
	}
}
