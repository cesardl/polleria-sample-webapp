package org.sanmarcux.controller;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sanmarcux.domain.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created on 27/05/2018. Unit tests for {@link LoginServlet}.
 *
 * @author Cesardl
 */
@RunWith(JUnit4.class)
public class LoginServletTest {

    private static final String FAKE_URL = "fake.fk/hello";
    // Set up a helper so that the ApiProxy returns a valid environment for local testing.
    private final LocalServiceTestHelper helper = new LocalServiceTestHelper();

    @Mock
    private HttpServletRequest mockRequest;
    @Mock
    private HttpServletResponse mockResponse;
    @Mock
    private RequestDispatcher rd;
    @Mock
    private HttpSession session;

    private StringWriter responseWriter;
    private LoginServlet servletUnderTest;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        helper.setUp();

        //  Set up some fake HTTP requests
        when(mockRequest.getRequestURI()).thenReturn(FAKE_URL);

        // Set up a fake HTTP response.
        responseWriter = new StringWriter();
        when(mockResponse.getWriter()).thenReturn(new PrintWriter(responseWriter));

        servletUnderTest = new LoginServlet();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }

    @Test
    public void doGetWritesResponse() throws Exception {
        when(mockRequest.getParameter("j_user")).thenReturn("admin");
        when(mockRequest.getParameter("j_passwd")).thenReturn("admin");
        when(mockRequest.getParameter("login")).thenReturn("");
        when(mockRequest.getRequestDispatcher(eq("bienvenido.jsp"))).thenReturn(rd);
        when(mockRequest.getSession(true)).thenReturn(session);

        servletUnderTest.doPost(mockRequest, mockResponse);

        verify(session).setAttribute("admin_visible", true);
        verify(session).setAttribute(eq("usuario"), any(Usuario.class));
    }

    @Test
    public void servletInfoTest() {
        String result = servletUnderTest.getServletInfo();
        assertThat(result).isEqualTo("Short description");
    }
}