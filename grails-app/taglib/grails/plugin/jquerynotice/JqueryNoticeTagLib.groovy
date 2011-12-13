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

}
