package edu.uned.missi.tfm.appiumlib.model;

import java.math.BigDecimal;

public enum Expression {

	equals, contains, startsWith, endsWith, greaterThan, greaterEqualsThan, lessThan, lessEqualsThan;

	public boolean evaluate(String op1, String op2) {

		if (op1 == null || op2 == null) {
			return false;
		}

		switch (this) {
		case equals:
			return op1.equals(op2);
		case contains:
			return op1.contains(op2);
		case startsWith:
			return op1.startsWith(op2);
		case endsWith:
			return op1.endsWith(op2);
		case greaterThan:
		case greaterEqualsThan:
		case lessThan:
		case lessEqualsThan:
			return numberEvaluation(op1, op2);
		default:
			break;
		}

		return false;
	}

	private boolean numberEvaluation(String op1, String op2) {
		BigDecimal nOp1 = new BigDecimal(op1);
		BigDecimal nOp2 = new BigDecimal(op2);
		switch (this) {
		case greaterThan:
			return nOp1.compareTo(nOp2) > 0;
		case greaterEqualsThan:
			return nOp1.compareTo(nOp2) >= 0;
		case lessThan:
			return nOp1.compareTo(nOp2) < 0;
		case lessEqualsThan:
			return nOp1.compareTo(nOp2) <= 0;
		default:
			break;
		}
		return false;
	}

}
