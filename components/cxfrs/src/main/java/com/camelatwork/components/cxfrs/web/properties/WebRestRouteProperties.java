package com.camelatwork.components.cxfrs.web.properties;

public class WebRestRouteProperties 
{
	private String feedbackQueue;

    public String getFeedbackQueue()
    {
        return feedbackQueue;
    }

    public void setFeedbackQueue(String feedbackQueue)
    {
        this.feedbackQueue = feedbackQueue;
    }

    public String toString()
    {
        String properties =
            "feedbackQueue: " + feedbackQueue;
        return properties;
    }
}
