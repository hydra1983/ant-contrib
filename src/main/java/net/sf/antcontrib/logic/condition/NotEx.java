package net.sf.antcontrib.logic.condition;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.taskdefs.condition.Condition;

public class NotEx extends BooleanConditionBase {
	public boolean eval() throws BuildException {
		if (countConditions() > 1) {
			throw new BuildException("You must not nest more than one "
					+ "condition into <not>");
		}
		if (countConditions() < 1) {
			throw new BuildException("You must nest a condition into <not>");
		}
		return !((Condition) getConditions().nextElement()).eval();
	}
}
