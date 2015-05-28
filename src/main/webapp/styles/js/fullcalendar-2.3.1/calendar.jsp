<%-- 
    Document   : calendar
    Created on : 25 mai 2015, 16:20:48
    Author     : EK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset='utf-8' />

	<link href='${pageContext.request.contextPath}/styles/js/fullcalendar-2.3.1/fullcalendar.css' rel='stylesheet' />
	<link href='${pageContext.request.contextPath}/styles/js/fullcalendar-2.3.1/fullcalendar.print.css' rel='stylesheet' media='print' />
	<link href='${pageContext.request.contextPath}/styles/js/fullcalendar-2.3.1/calendar.css' rel='stylesheet' />

        <script src='${pageContext.request.contextPath}/styles/js/jquery-1.11.2.min.js'></script>
	<script src='${pageContext.request.contextPath}/styles/js/fullcalendar-2.3.1/lib/moment.min.js'></script>
	<script src='${pageContext.request.contextPath}/styles/js/fullcalendar-2.3.1/lib/fullcalendar.min.js'></script>
	<script src='${pageContext.request.contextPath}/styles/js/fullcalendar-2.3.1/lib/lang-all.js'></script>
	<script>
            
		$(document).ready(function() {
			$('#calendar').fullCalendar({
				lang: 'fr',
				header: {
					left: 'prev,next today',
					center: 'title',
					right: 'month,basicWeek,basicDay'
				},
				editable: true,
				eventLimit: true, // allow "more" link when too many events
				events: [
						{
							title: 'All Day Event',
							start: '2015-05-01'
						},
						{
							title: 'Long Event',
							start: '2015-05-07',
							end: '2015-05-10'
						},
						{
							id: 999,
							title: 'Repeating Event',
							start: '2015-05-09T16:00:00'
						},
						{
							id: 999,
							title: 'Repeating Event',
							start: '2015-05-16T16:00:00'
						},
						{
							title: 'Conference',
							start: '2015-05-11',
							end: '2015-05-13'
						},
						{
							title: 'Meeting',
							start: '2015-05-12T10:30:00',
							end: '2015-05-12T12:30:00'
						},
						{
							title: 'Lunch',
							start: '2015-05-12T12:00:00'
						},
						{
							title: 'Meeting',
							start: '2015-05-12T14:30:00'
						},
						{
							title: 'Happy Hour',
							start: '2015-05-12T17:30:00'
						},
						{
							title: 'Dinner',
							start: '2015-05-12T20:00:00'
						},
						{
							title: 'Birthday Party',
							start: '2015-05-13T07:00:00'
						},
						{
							title: 'Click for Google',
							url: 'http://google.com/',
							start: '2015-05-28'
						}
					]
				
			});
			
		});
	</script>
</head>
<body>
</body>
</html>
