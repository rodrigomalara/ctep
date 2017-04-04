package br.com.ctep.stripes;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

import org.apache.commons.logging.Log;

public abstract class BaseActionBean implements ActionBean {

	protected Log log;

	private ActionBeanContext context;

	public ActionBeanContext getContext() {
		return context;
	}

	public void setContext(ActionBeanContext actionBeanContext) {
		this.context = actionBeanContext;
	}
}
