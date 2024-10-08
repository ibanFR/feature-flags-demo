/*
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR(S) DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR(S) BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER
 * RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT,
 * NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE
 * USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package com.ibanfr.viewscoped;

import java.io.Serializable;
import java.util.Date;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

/**
 * A view scoped bean.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
@Named(value = "viewScopedBean")
@ViewScoped
public class IndexBean implements Serializable {

    /**
     * Stores the time.
     */
    private String time;

    /**
     * Different view.
     *
     * @return "different"
     */
    public String differentView() {
        return "different";
    }

    /**
     * Index view.
     *
     * @return "index"
     */
    public String indexView() {
        return "index";
    }

    /**
     * Initialize the bean.
     */
    @PostConstruct
    public void initialize() {
        time = new Date().toString() + " - " + System.nanoTime();
    }

    /**
     * Get the time.
     *
     * @return the time.
     */
    public String getTime() {
        return time;
    }

    /**
     * Same view.
     *
     * @return ""
     */
    public String sameView() {
        return "";
    }
}
