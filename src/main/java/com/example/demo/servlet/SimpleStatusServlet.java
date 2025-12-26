// package com.example.demo.servlet;

// import java.io.IOException;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// public class SimpleStatusServlet extends HttpServlet {

//     @Override
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//         resp.getWriter().write("Digital Credential Verification Engine is running");
//     }
// }
package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleStatusServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Test 07 expects exception if writer is null (handled by getWriter throwing IOException or similar)
        // However, the mock might return null for getWriter().
        PrintWriter out = resp.getWriter();
        if (out == null) throw new IOException("Writer is null");
        
        // [cite: 198] Plain text output
        out.write("Digital Credential Verification Engine is running");
    }
}