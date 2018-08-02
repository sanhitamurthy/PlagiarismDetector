package detector.implmentation.java;

import org.eclipse.jdt.core.dom.ASTNode;

/**
 *
 * Custom hash code depending upon the node of interest.
 */
public class AstNodeHashCodeMap {

	public AstNodeHashCodeMap() {
	}

	/**
	 * getHashCode(String file, int pos)
	 *
	 * @param node :The node from the AST which has been created from the file which was given as input
	 * @return the custom hash code value of node based on the type of the node
	 */
	public static int getHashCode(ASTNode node) {
		int nodeType = node.getNodeType();

		switch (nodeType) {

			case ASTNode.ARRAY_ACCESS :
				return 1;
			case ASTNode.ARRAY_CREATION :
				return 2;
			case ASTNode.ARRAY_INITIALIZER :
				return 3;
			case ASTNode.ARRAY_TYPE :
				return 4;
			case ASTNode.ASSIGNMENT :
				return 5;
			case ASTNode.BREAK_STATEMENT :
				return 6;
			case ASTNode.CAST_EXPRESSION :
				return 7;
			case ASTNode.CATCH_CLAUSE :
				return 8;
			case ASTNode.CLASS_INSTANCE_CREATION :
				return 9;
			case ASTNode.COMPILATION_UNIT :
				return 10;

			case ASTNode.ENUM_CONSTANT_DECLARATION :
				return 13;
			case ASTNode.ENUM_DECLARATION :
				return 13;
			case ASTNode.FIELD_ACCESS :
				return 14;
			case ASTNode.FIELD_DECLARATION :
				return 15;
			case ASTNode.INITIALIZER :
				return 16;

			case ASTNode.MEMBER_VALUE_PAIR :
				return 18;
			case ASTNode.METHOD_DECLARATION :
				return 19;
			case ASTNode.METHOD_INVOCATION :
				return 20;

			case ASTNode.SIMPLE_NAME :
				return 27;

			case ASTNode.CHARACTER_LITERAL :
				return 39;
			case ASTNode.BOOLEAN_LITERAL :
				return 39;
			case ASTNode.NUMBER_LITERAL :
				return 39;
			case ASTNode.FOR_STATEMENT :
				return 41;
			case ASTNode.WHILE_STATEMENT :
				return 73;
			case ASTNode.INFIX_EXPRESSION :
				return 42;
			case ASTNode.EXPRESSION_STATEMENT :
				return 42;
			case ASTNode.IF_STATEMENT :
				return 43;
			default:
				return 0;
		}
	}

}