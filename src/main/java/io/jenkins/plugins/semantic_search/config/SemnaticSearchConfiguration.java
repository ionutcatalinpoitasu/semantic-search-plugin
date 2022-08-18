package io.jenkins.plugins.semantic_search.config;

import hudson.Extension;
import hudson.model.ManagementLink;

@Extension
public class SemnaticSearchConfiguration  extends ManagementLink {

    @Override
    public String getIconFileName() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return "Semantic Search";
    }

    @Override
    public String getUrlName() {
        return "semantic-search";
    }
}
