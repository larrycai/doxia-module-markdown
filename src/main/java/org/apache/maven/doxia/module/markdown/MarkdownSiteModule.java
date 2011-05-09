package org.apache.maven.doxia.module.markdown;

import org.apache.maven.doxia.module.site.AbstractSiteModule;

/**
 *
 * @author <a href="mailto:decamps@users.sf.net">Régis Décamps</a>
 * @version $Id$
 * @since 1.0
 * @plexus.component role="org.apache.maven.doxia.module.site.SiteModule"
 *                   role-hint="markdown"
 */
public class MarkdownSiteModule extends AbstractSiteModule {
	public MarkdownSiteModule() {
		super("markdown", "md", "markdown");
		System.out.println("Loading Markdown site plugin");
	}
}
