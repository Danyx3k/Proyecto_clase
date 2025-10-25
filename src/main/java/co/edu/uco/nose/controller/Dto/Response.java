package co.edu.uco.nose.controller.Dto;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;

import java.util.ArrayList;
import java.util.List;

public final class Response <T>{

    private List<String> messages;
    private List<T> data;
    private boolean responseSucceded;


    public Response(final Boolean responseSucceded){
        setResponseSucceded(responseSucceded);
        setMessages(new ArrayList<String>());
        setData(new ArrayList<T>());
    }

    public void addMessages(String message) {
        if(TextHelper.isEmptyWithTrim(message)){
            getMessages().add(message);
        }
    }
    public Response(final List<String> messages,final List<T> data, final boolean responseSucceded ){
        setMessages(messages);
        setData(data);
        setResponseSucceded(responseSucceded);

    }

    public static <T> Response<T> createSuccededResponse(){
        return new Response<>(new ArrayList<String>(), new ArrayList<>(),true);
    }

    public static <T> Response <T> createFailedResponse(){
        return new Response<>(new ArrayList<String>(), new ArrayList<>(),false);
    }

    public static <T> Response<T> createSuccededResponse(final List<T> data){
        return new Response<>(new ArrayList<String>(), data,true);
    }

    public static <T> Response <T> createFailedResponse(final List<T> data){
        return new Response<>(new ArrayList<String>(), data ,false);
    }

    public List<String> getMessages() {
        return ObjectHelper.getDefault(messages, new ArrayList<String>());
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = ObjectHelper.getDefault(data, new ArrayList<T>());
    }

    public boolean isResponseSucceded() {
        return responseSucceded;
    }

    public void setResponseSucceded(boolean responseSucceded) {
        this.responseSucceded = responseSucceded;
    }
}
