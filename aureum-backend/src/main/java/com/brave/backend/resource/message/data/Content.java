package com.brave.backend.resource.message.data;

import java.util.List;

public class Content
{
    /** The text. */
    private String text;
    
    /** The image urls. */
    private List<String> imageUrls;
    
    public String getText()
    {
        return text;
    }
    
    public void setText(String text)
    {
        this.text = text;
    }
    
    public List<String> getImageUrls()
    {
        return imageUrls;
    }
    
    public void setImageUrls(List<String> imageUrls)
    {
        this.imageUrls = imageUrls;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Content [text=");
        builder.append(text);
        builder.append(", imageUrls=");
        builder.append(imageUrls);
        builder.append("]");
        return builder.toString();
    }
}
