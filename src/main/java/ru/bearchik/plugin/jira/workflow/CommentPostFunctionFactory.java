package ru.bearchik.plugin.jira.workflow;

import com.atlassian.jira.plugin.workflow.AbstractWorkflowPluginFactory;
import com.atlassian.jira.plugin.workflow.WorkflowPluginFunctionFactory;
import com.atlassian.jira.workflow.JiraWorkflow;
import com.atlassian.jira.workflow.WorkflowManager;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.JiraImport;
import com.opensymphony.workflow.loader.*;
import webwork.action.ActionContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the factory class responsible for dealing with the UI for the post-function.
 * This is typically where you put default values into the velocity context and where you store user input.
 */

@Scanned
public class CommentPostFunctionFactory extends AbstractWorkflowPluginFactory implements WorkflowPluginFunctionFactory
{
    public static final String FIELD_FROM = "from_comment_field";
    public static final String FIELD_COMMENT = "comment_text_area";

    @JiraImport
    private WorkflowManager workflowManager;

    public CommentPostFunctionFactory(WorkflowManager workflowManager) {
        this.workflowManager = workflowManager;
    }

    @Override
    protected void getVelocityParamsForInput(Map<String, Object> velocityParams) {
        Map<String, String[]> myParams = ActionContext.getParameters();
        final JiraWorkflow jiraWorkflow = workflowManager.getWorkflow(myParams.get("workflowName")[0]);

        //the default message
        velocityParams.put(FIELD_COMMENT, "Enter default comment.");

    }

    @Override
    protected void getVelocityParamsForEdit(Map<String, Object> velocityParams, AbstractDescriptor descriptor) {
        getVelocityParamsForInput(velocityParams);
        getVelocityParamsForView(velocityParams, descriptor);
    }

    @Override
    protected void getVelocityParamsForView(Map<String, Object> velocityParams, AbstractDescriptor descriptor) {
        if (!(descriptor instanceof FunctionDescriptor)) {
            throw new IllegalArgumentException("Descriptor must be a FunctionDescriptor.");
        }


        FunctionDescriptor functionDescriptor = (FunctionDescriptor)descriptor;

        String message = (String)functionDescriptor.getArgs().get(FIELD_FROM);

        if (message == null) {
            message = "No Message";
        }

        velocityParams.put(FIELD_FROM,message);

        message = (String)functionDescriptor.getArgs().get(FIELD_COMMENT);

        if (message == null) {
            message = "No Message";
        }

        velocityParams.put(FIELD_COMMENT,message);

    }


    public Map<String,?> getDescriptorParams(Map<String, Object> formParams) {
        Map params = new HashMap();

        // Process The map
        String message = extractSingleParam(formParams,FIELD_FROM);
        params.put(FIELD_FROM,message);
        message = extractSingleParam(formParams,FIELD_COMMENT);
        params.put(FIELD_COMMENT,message);

        return params;
    }

}