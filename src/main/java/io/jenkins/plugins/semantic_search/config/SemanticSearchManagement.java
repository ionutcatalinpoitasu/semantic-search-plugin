package io.jenkins.plugins.semantic_search.config;

import hudson.Extension;
import hudson.model.*;
import hudson.security.Permission;
import jenkins.model.Jenkins;
import jenkins.model.ModelObjectWithContextMenu;
import org.kohsuke.stapler.StaplerProxy;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Extension
public class SemanticSearchManagement extends ManagementLink implements StaplerProxy, Describable<SemanticSearchManagement>,
        Saveable, ModelObjectWithContextMenu {

    public static final String URL_NAME = "semantic-search";

    private static final Logger logger = LoggerFactory.getLogger(SemanticSearchManagement.class);

    @Override
    public ContextMenu doContextMenu(StaplerRequest request, StaplerResponse response) throws Exception {
        return null;
    }

    @Extension
    public static final class DescriptorImpl extends Descriptor<SemanticSearchManagement> {

        @Override
        public String getDisplayName() {
            return "Semantic Search";
        }

    }

    @Override
    public String getIconFileName() {
        return "icon.png";
    }

    @Override
    public String getUrlName() {
        return URL_NAME;
    }

    @Override
    public String getDisplayName() {
        return "Semantic Search";
    }

    @Override
    public String getDescription() {
        return "This plugin allows a natural language search based on entities and conditions";
    }

    @Override
    public DescriptorImpl getDescriptor() {
        return Jenkins.get().getDescriptorByType(DescriptorImpl.class);
    }


    @Override
    public Object getTarget() {
        Jenkins jenkins = Jenkins.get();
        jenkins.checkPermission(Jenkins.ADMINISTER);
        return this;
    }

    @Override
    public void save() throws IOException {
        logger.debug("Save");
    }



    private void checkPermission() {
        final Jenkins jenkins = Jenkins.getInstanceOrNull();
        if (jenkins != null) {
            jenkins.checkPermission(getRequiredPermission());
        }
    }

    @Override
    public Permission getRequiredPermission() {
        return Jenkins.ADMINISTER;
    }

}
