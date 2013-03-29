package net.sf.antcontrib.logic.condition;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.ProjectComponent;
import org.apache.tools.ant.taskdefs.condition.Condition;

public class EndsWith extends ProjectComponent implements Condition {

	private String string = null;
	private String propertyName = null;
	private String with = null;

	public void setString(String s) {
		this.string = s;
	}

	public void setProperty(String s) {
		this.propertyName = s;
	}

	public void setWith(String w) {
		this.with = getProject().replaceProperties(w);
	}

	public boolean eval() throws BuildException {
		if (string == null || propertyName == null)
			throw new BuildException("string or property must be set.");
		if (with == null)
			throw new BuildException("with must be set.");

		if (string != null)
			return string.endsWith(with);
		else {
			String propertyValue = getProject().getProperty(propertyName);
			return propertyValue == null ? false : propertyValue.endsWith(with);
		}
	}
}
