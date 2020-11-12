#Cookies, Sessions, Servlets #3 Continuation
###Custom Session implementation
Session exists only on the Server side.

To track cookies for 100_000 web site visitors requires 100_000 * 10kB = 1GB of cookie data in heap.

web.xml:
```
<session-config>
        <--Time to live from the last usage: -->
        <session-timeout>mins<session-timeout> 

<session-config>
```
    

 