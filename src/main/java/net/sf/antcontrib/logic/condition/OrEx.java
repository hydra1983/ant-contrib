package net.sf.antcontrib.logic.condition;

import java.util.Enumeration;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.taskdefs.condition.Condition;

public class OrEx extends BooleanConditionBase {
	public boolean eval() throws BuildException {
		Enumeration e = getConditions();
		while (e.hasMoreElements()) {
			Condition c = (Condition) e.nextElement();
			if (c.eval()) {
				return true;
			}
		}
		return false;
	}
}
