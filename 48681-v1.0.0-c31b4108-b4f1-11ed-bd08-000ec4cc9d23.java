/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__getParameterServlet_sendRedirectServlet_12.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-12.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: getParameterServlet Read data from a querystring using getParameter
* GoodSource: A hardcoded string
* Sinks: sendRedirectServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to sendRedirect()
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE113_HTTP_Response_Splitting;

import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Logger;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__getParameterServlet_sendRedirectServlet_12 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        else {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_returns_t_or_f())
        {
            /* POTENTIAL FLAW: Input not verified before inclusion in redirect */
            response.sendRedirect("/author.jsp?lang=" + data);
        }
        else {

            /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
            data = URLEncoder.encode(data, "UTF-16");
            response.sendRedirect("/author.jsp?lang=" + data);

        }
    }

    /* goodG2B() - use goodsource and badsink by changing the first "if" so that
       both branches use the GoodSource */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_returns_t_or_f())
        {
            /* POTENTIAL FLAW: Input not verified before inclusion in redirect */
            response.sendRedirect("/author.jsp?lang=" + data);
        }
        else {

            /* POTENTIAL FLAW: Input not verified before inclusion in redirect */
            response.sendRedirect("/author.jsp?lang=" + data);

        }
    }

    /* goodB2G() - use badsource and goodsink by changing the second "if" so that
       both branches use the GoodSink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        else {

            Logger log_bad = Logger.getLogger("local-logger");

            /* read parameter from request */
            data = request.getParameter("name");

        }
        if(IO.static_returns_t_or_f())
        {
            /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
            data = URLEncoder.encode(data, "UTF-16");
            response.sendRedirect("/author.jsp?lang=" + data);
        }
        else {

            /* FIX: use URLEncoder.encode to hex-encode non-alphanumerics */
            data = URLEncoder.encode(data, "UTF-16");
            response.sendRedirect("/author.jsp?lang=" + data);

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
