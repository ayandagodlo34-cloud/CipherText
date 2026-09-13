<%-- 
    Document   : result
    Created on : Sep 13, 2026, 9:31:16 PM
    Author     : Aya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result</title>
    <style>
        body { font-family: sans-serif; max-width: 540px; margin: 3rem auto; padding: 1rem; }
        h1 { color: #4f8cff; }
        .box {
            background: #f2f4f8; padding: 1rem; border-radius: 8px;
            margin: 1rem 0; word-wrap: break-word; font-family: monospace;
        }
        .label { font-size: .8rem; color: #666; text-transform: uppercase; letter-spacing: .05em; }
        .pill { background: #4f8cff; color: #fff; padding: .25rem .75rem;
                border-radius: 20px; font-size: .85rem; }
        a { display: inline-block; margin-top: 1.5rem; color: #4f8cff; text-decoration: none; }
        .nav-links a { margin-right: 1rem; }
    </style>
</head>
<body>
    <h1>${operation} Result</h1>

    <p><span class="pill">Shift key: ${shift}</span></p>

    <p class="label">Original</p>
    <div class="box">${original}</div>

    <p class="label">${operation}ed</p>
    <div class="box"><strong>${processed}</strong></div>

    <p style="color:#666; font-size:.9rem;">Total operations so far: <strong>${totalOps}</strong></p>

    <div class="nav-links">
        <a href="${pageContext.request.contextPath}/index.jsp">← Try another</a>
        <a href="${pageContext.request.contextPath}/HistoryServlet.do">View history</a>
    </div>
</body>
</html>
