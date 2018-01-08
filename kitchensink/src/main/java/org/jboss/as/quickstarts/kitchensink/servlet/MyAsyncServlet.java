package org.jboss.as.quickstarts.kitchensink.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyAsyncServlet
 */
@WebServlet(urlPatterns = "/MyAsyncServlet", asyncSupported = true)
public class MyAsyncServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AsyncContext asyncCtx = request.startAsync(request, response);
        ServletInputStream input = request.getInputStream();
        ReadListener readListener = new ReadListenerImpl(input, response, asyncCtx);
        input.setReadListener(readListener);
    }

    private static class ReadListenerImpl implements ReadListener {
        private final ServletInputStream input;
        private final HttpServletResponse response;
        private final AsyncContext ac;
        private StringBuilder sb = new StringBuilder();

        public ReadListenerImpl(ServletInputStream input, HttpServletResponse response, AsyncContext ac) {
            this.input = input;
            this.response = response;
            this.ac = ac;
        }

        @Override
        // データ読込可能になるとコールバックされる
        public void onDataAvailable() throws IOException {
            int len;
            byte[] b = new byte[1024];
            while (input.isReady() && !input.isFinished() && (len = input.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }
        }


        @Override
        // 全データを読み終わるとコールバックされる
        public void onAllDataRead() throws IOException {
            // ここに何らかのレスポンス生成コードを記述
            ServletOutputStream output = response.getOutputStream();
            WriteListener writeListener = new WriteListenerImpl(output, ac);
            output.setWriteListener(writeListener);
        }

        @Override
        // エラー時にコールバックされる
        public void onError(final Throwable t) {
            ac.complete();
            t.printStackTrace();
        }
    }

    static class WriteListenerImpl implements WriteListener {
        private final ServletOutputStream output;
        private final AsyncContext ac;

        public WriteListenerImpl(ServletOutputStream output, AsyncContext ac) {
            this.output = output;
            this.ac = ac;
        }

        @Override
        // データ書込可能になるとコールバックされる
        public void onWritePossible() throws IOException {
            output.print("<body>result</body>");
            output.flush();
            ac.complete();
        }

        @Override
        public void onError(final Throwable t) {
            ac.complete();
            t.printStackTrace();
        }

    }
}
