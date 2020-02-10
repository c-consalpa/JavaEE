/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import javax.servlet.http.Cookie;

/**
 *
 * @author c-consalpa
 */
public class CookieUtils {
    
    public static String getCookieValue(String name, Cookie[] cookies) {
        String coockieValue = "";
        if (cookies != null) {
            for(Cookie c: cookies) {
                if (name.equals(c.getName())) coockieValue = c.getValue();
            }
        }
        return coockieValue;
    }
    
    public static String listAllCookies(Cookie[] cookies) {
        StringBuilder sb = new StringBuilder();
        if (cookies != null) {
            for(Cookie c: cookies) {
                sb.append(c.getName());
                sb.append(" : ");
                sb.append(c.getValue());
                sb.append("\r\n");
            }
        }
        return sb.toString();
    }

    public static void invalidateCookies(Cookie[] cookies) {
       if (cookies != null) {
            for(Cookie c: cookies) {
               c.setMaxAge(0);
               c.setPath("/");
            }
        }
    }
    
}
