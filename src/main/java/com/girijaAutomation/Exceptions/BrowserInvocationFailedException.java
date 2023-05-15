/**
 * Author : lenovo
 * Date : 13-05-2023
 * Time : 06:35 pm
 * Project Nmae : AuromationProject
 * Year : 2023
 */
package com.girijaAutomation.Exceptions;

public class BrowserInvocationFailedException extends FrameworkExceptions{
    public BrowserInvocationFailedException(String message) {
        super(message);
    }

    public BrowserInvocationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
