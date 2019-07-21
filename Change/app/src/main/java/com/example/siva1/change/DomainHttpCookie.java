package com.example.siva1.change;

import android.os.Build;
import android.util.Log;

import java.net.HttpCookie;

public class DomainHttpCookie {
    // The value of the cookie itself.
    private String name;  // NAME= ... "$Name" style is reserved
    private String value;       // value of NAME

    // Attributes encoded in the header's cookie fields.
    private String comment;     // Comment=VALUE ... describes cookie's use
    private String commentURL;  // CommentURL="http URL" ... describes cookie's use
    private boolean toDiscard;  // Discard ... discard cookie unconditionally
    private String domain;      // Domain=VALUE ... domain that sees cookie
    private long maxAge;  // Max-Age=VALUE ... cookies auto-expire
    private String path;        // Path=VALUE ... URLs that see the cookie
    private String portlist;    // Port[="portlist"] ... the port cookie may be returned to
    private boolean secure;     // Secure ... e.g. use SSL
    private boolean httpOnly;   // HttpOnly ... i.e. not accessible to scripts
    private int version = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentURL() {
        return commentURL;
    }

    public void setCommentURL(String commentURL) {
        this.commentURL = commentURL;
    }

    public boolean isToDiscard() {
        return toDiscard;
    }

    public void setToDiscard(boolean toDiscard) {
        this.toDiscard = toDiscard;
    }

    public void setDiscard(boolean toDiscard){
        this.toDiscard = toDiscard;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public long getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(long maxAge) {
        this.maxAge = maxAge;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPortlist() {
        return portlist;
    }

    public void setPortlist(String portlist) {
        this.portlist = portlist;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public boolean isHttpOnly() {
        return httpOnly;
    }

    public void setHttpOnly(boolean httpOnly) {
        this.httpOnly = httpOnly;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public HttpCookie makeHttpCookie(){
        HttpCookie cookie = null;
        cookie = new HttpCookie(this.name, this.value);
        cookie.setComment(this.comment);
        cookie.setCommentURL(this.commentURL);
        cookie.setDiscard(this.toDiscard);
        cookie.setDomain(this.domain);
        cookie.setMaxAge(this.maxAge);
        cookie.setPath(this.path);
        cookie.setPortlist(this.portlist);

        //TODO:Move this logic to the server side.
        if(Constants.API_URL.contains("https"))
            cookie.setSecure(true);
        else{
            cookie.setSecure(false);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            cookie.setHttpOnly(this.httpOnly);
        }
        cookie.setVersion(this.version);
        Log.d("COOKIE" , cookie.toString());
        return cookie;
    }
}
