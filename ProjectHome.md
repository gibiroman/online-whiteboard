## <font color='#996B33'>Description</font> ##

**Online-Whiteboard** is a framework and academic web application built on top of the Raphaël / jQuery JavaScript libraries, Atmosphere framework and HTML5 WebSockets. Raphaël simplifies the work with vector graphics on the web. Chosen Server-Push frameworks exemplify real-time collaborations on basis different approaches and bidirectional protocols. The web front-end leverages JavaServer Faces and uses PrimeFaces as JSF component library. The application is cross-browser compatible and runs in any modern browsers.

By means of the collaborative Whiteboard you are able to draw shapes like rectangle, circle, ellipse, draw free, straight lines, input any text and paste images or predefined icons. Whiteboard's elements have editable properties like coordinates, color, width, height, scale factor, etc. They can be rearranged per drag-&-drop. Changes on the Whiteboard are propagated to all participants in real-time. Tracking of activities is possible via an event monitoring as well. You can also invite people to participate in existing Whiteboard's collaborations.

Online-Whiteboard is an open source project licensed under Apache License V2. You can use it completely free in open source or commercial projects following the terms of the license.
<br />
## <font color='#996B33'>Project Resources</font> ##

<img src='http://fractalsoft.de/common/images/showcase.png' align='top'> <b>Showcase</b>

<ul><li>Demo web application is not deployed anymore online (since 07.01.2012). You can <a href='http://code.google.com/p/online-whiteboard/downloads/list'>download executable WAR files</a> for all three supported transports: Long-Polling, Streaming and WebSocket.</li></ul>

<img src='http://fractalsoft.de/common/images/document.png' align='top'> <b>Documentation</b>

<ul><li><a href='http://fractalsoft.de/uni/apidocs/index.html'>JavaDoc</a> and <a href='http://fractalsoft.de/uni/jsdoc/index.html'>JSDoc</a> are available online.</li></ul>

<img src='http://fractalsoft.de/common/images/download.png' align='top'> <b>Download and Setup</b>

<ul><li>The last stable WAR files can be downloaded from the <a href='http://code.google.com/p/online-whiteboard/downloads/list'>"Downloads" section</a>. They are executable. That means you can open your preferred console / terminal, go to the file location and type e.g.<br>
<pre><code>java -jar whiteboard-long-polling.war<br>
</code></pre>
</li></ul><blockquote>A small Java GUI will be started where you can push "Start" button to run corresponding web application. That's all. The web application will be opened in your default browser, but you can copy URL location and call it in any other browser.<br>
</blockquote><ul><li>The showcase web application is provided with jetty-maven-plugin. Therefore, you can also check out the latest source code and let run it with Jetty. Install a svn command line client, open your preferred console / terminal and type<br>
<pre><code>svn checkout http://online-whiteboard.googlecode.com/svn/trunk/ online-whiteboard<br>
</code></pre>
</li></ul><blockquote>Then, from the same directory as the root pom.xml, simply type:<br>
<pre><code>mvn jetty:run<br>
</code></pre>
This starts Jetty server and the project is available under the following URL in a web browser:<br>
<pre><code>http://localhost:8080/whiteboard-showcase<br>
</code></pre>
Jetty will continue to run until you stop it with a <Ctrl+C> in the console / terminal window where it is running.</blockquote>

<img src='http://fractalsoft.de/common/images/resources.png' align='top'> <b>Links</b>
<ul><li><a href='http://en.wikipedia.org/wiki/Ajax_%28programming%29'>Ajax (Asynchronous JavaScript and XML)</a>
</li><li><a href='http://en.wikipedia.org/wiki/Push_technology'>Server-Push technology</a>
</li><li><a href='http://raphaeljs.com/'>JavaScript Library Raphaël</a>
</li><li><a href='http://atmosphere.java.net/'>Atmosphere Framework</a>
</li><li><a href='http://dev.w3.org/html5/websockets/'>WebSockets API</a>
</li><li><a href='http://www.primefaces.org/'>PrimeFaces</a>