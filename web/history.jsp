<%-- 
    Document   : history
    Created on : Sep 13, 2026, 9:32:13 PM
    Author     : Aya
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entity.CipherRecord"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cipher History</title>
    <style>
        body { font-family: sans-serif; max-width: 900px; margin: 3rem auto; padding: 1rem; }
        h1 { color: #4f8cff; }
        table { width: 100%; border-collapse: collapse; margin-top: 1rem; font-size: .9rem; }
        th, td { text-align: left; padding: .6rem; border-bottom: 1px solid #eee; }
        th { background: #f7f8fa; }
        td.text { font-family: monospace; max-width: 240px; overflow: hidden;
                  text-overflow: ellipsis; white-space: nowrap; }
        .enc { color: #2e9e5b; font-weight: 600; }
        .dec { color: #d33; font-weight: 600; }
        a { color: #4f8cff; text-decoration: none; }
    </style>
</head>
<body>
    <h1>Cipher History</h1>
    <p>Total operations: <strong>${totalOps}</strong></p>

    <table>
        <tr>
            <th>#</th>
            <th>Operation</th>
            <th>Key</th>
            <th>Original</th>
            <th>Result</th>
            <th>When</th>
        </tr>
        <%
            List<CipherRecord> records = (List<CipherRecord>) request.getAttribute("records");
            if (records != null) {
                int i = 1;
                for (CipherRecord r : records) {
                    String cssClass = "Encrypt".equals(r.getOperation()) ? "enc" : "dec";
        %>
        <tr>
            <td><%= i++ %></td>
            <td class="<%= cssClass %>"><%= r.getOperation() %></td>
            <td><%= r.getShiftKey() %></td>
            <td class="text"><%= r.getOriginalText() %></td>
            <td class="text"><%= r.getProcessedText() %></td>
            <td><%= r.getTimestamp() %></td>
        </tr>
        <%
                }
            }
        %>
    </table>

    <p style="margin-top:2rem">
        <a href="${pageContext.request.contextPath}/index.jsp">← Back to cipher</a>
    </p>
</body>
</html>
