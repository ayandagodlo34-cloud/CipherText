<%-- 
    Document   : index
    Created on : Sep 13, 2026, 9:28:56 PM
    Author     : Aya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Encrypt / Decrypt</title>
    <style>
        body { font-family: sans-serif; max-width: 540px; margin: 3rem auto; padding: 1rem; }
        h1 { color: #4f8cff; }
        label { display: block; margin-top: 1rem; font-weight: 500; }
        textarea, input, button {
            width: 100%; padding: .6rem; margin-top: .3rem;
            box-sizing: border-box; border: 1px solid #ccc;
            border-radius: 6px; font-size: 1rem; font-family: inherit;
        }
        textarea { min-height: 90px; resize: vertical; }
        .row { display: flex; gap: 1rem; margin-top: 1.5rem; }
        .row button { flex: 1; margin-top: 0; }
        button {
            background: #4f8cff; color: #fff; border: none;
            cursor: pointer; font-weight: 600;
        }
        button:hover { background: #6ea0ff; }
        button.secondary { background: #666; }
        button.secondary:hover { background: #888; }
        .error { color: #d33; background: #fee; padding: .75rem; border-radius: 6px; margin-bottom: 1rem; }
        .nav { text-align: right; margin-bottom: 1rem; }
        .nav a { color: #4f8cff; text-decoration: none; }
    </style>
</head>
<body>
    <div class="nav">
        <a href="${pageContext.request.contextPath}/HistoryServlet">View History →</a>
    </div>

    <h1>Encrypt / Decrypt</h1>

    <% if (request.getAttribute("error") != null) { %>
        <div class="error">${error}</div>
    <% } %>

    <form id="cryptoForm" method="post">
        <label>Text</label>
        <textarea name="text" placeholder="Enter your message..." required></textarea>

        <label>Shift Key (1 - 25)</label>
        <input type="number" name="key" min="1" max="25" value="3" required>

        <div class="row">
            <button type="submit"
                    formaction="${pageContext.request.contextPath}/EncryptServlet.do">
                Encrypt 🔒
            </button>
            <button type="submit" class="secondary"
                    formaction="${pageContext.request.contextPath}/DecryptServlet.do">
                Decrypt 🔓
            </button>
        </div>
    </form>
</body>
</html>
