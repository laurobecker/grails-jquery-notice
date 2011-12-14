<head>
	<meta name="layout" content="default">
</head>
<body>
	<r:require module="jquery-notice-all"/>
	<n:notice text="Simple Notice" />
	<n:error text="Simple Error" />
	<n:success>
		Success with<br/>
		<h1>HTML body</h1>
	</n:success>
	<n:success text="Success with stay" stay="true" />
	
	<n:flashMessageNotice/>
	<n:flashErrorNotice/>
	<n:flashSuccessNotice/>
	<n:renderErrorsNotice bean="${bean}"/>
</body>