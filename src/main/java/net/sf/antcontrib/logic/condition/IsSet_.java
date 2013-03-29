package net.sf.antcontrib.logic.condition;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.ProjectComponent;
import org.apache.tools.ant.taskdefs.condition.Condition;

public class IsSet_ extends ProjectComponent implements Condition {
	private String property;

	public void setProperty(String p) {
		property = p;
	}

	public boolean eval() throws BuildException {
		if (property == null) {
			throw new BuildException("No property specified for isset "
					+ "condition");
		}

		String value = getProject().getProperty(property);
		return value != null && !value.matches("\\$\\{.*\\}");
	}
}