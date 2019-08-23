package ru.bearchik.plugin.jira.workflow;

import java.util.List;
import java.util.Map;

import com.atlassian.jira.bc.user.search.UserSearchParams;
import com.atlassian.jira.bc.user.search.UserSearchService;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.MutableIssue;
import com.atlassian.jira.issue.comments.CommentManager;
import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.jira.workflow.function.issue.AbstractJiraFunctionProvider;
import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.WorkflowException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the post-function class that gets executed at the end of the transition.
 * Any parameters that were saved in your factory class will be available in the transientVars Map.
 */
public class CommentPostFunction extends AbstractJiraFunctionProvider
{
    private static final Logger log = LoggerFactory.getLogger(CommentPostFunction.class);
    public static final String FIELD_FROM = "from_comment_field";
    public static final String FIELD_COMMENT = "comment_text_area";

    public void execute(Map transientVars, Map args, PropertySet ps) throws WorkflowException
    {

        MutableIssue issue = getIssue(transientVars);
        CommentManager commentManager = ComponentAccessor.getCommentManager();
        String fromuser = (String)args.get(FIELD_FROM);

        if (checkUserInJira(fromuser).getUsername() != null) {
            commentManager.create(issue, checkUserInJira(fromuser).getUsername(), (String)args.get(FIELD_COMMENT),true );
        }

    }

    ApplicationUser checkUserInJira(String user) {

        UserSearchService userSearchService = ComponentAccessor.getComponent(UserSearchService.class);
        List<ApplicationUser> users = userSearchService.findUsers(user, new UserSearchParams(false, true,false));

        if(users.size() == 0) {
            return null;
        }

        return users.get(0);
    }
}