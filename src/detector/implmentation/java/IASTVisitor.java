package detector.implmentation.java;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment.Operator;
import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.ASTNode;

import java.util.*;

/**
 * IASTVisitor
 * inherits from org.eclipse.jdt.core.dom.ASTVisitor
 * Overrides visit function to collect all ASTNodes in AST into a list
 *
 */
public class IASTVisitor extends ASTVisitor{

    List<ASTNode> nodes;

    /**
     * constructor of the IASTVisitor class
     * creates a list of nodes
     */
    public IASTVisitor() {
        super();
        nodes = new ArrayList<>();
    }

    //returns all the nodes of the AST
    public List<ASTNode> getNodes() {
        return this.nodes;
    }


    /**
     * visit function for ArrayAccess
     */
    public boolean visit(ArrayAccess node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for ArrayCreation
     */
    public boolean visit(ArrayCreation node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for ArrayInitializer
     */
    public boolean visit(ArrayInitializer node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for ArrayType
     */
    public boolean visit(ArrayType node) {
        nodes.add(node);
        return true;
    }

    /**
     * visit function for Assignment
     */
    public boolean visit(Assignment node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for Block
     */
//    public boolean visit(Block node) {
//        nodes.add(node);
//        return true;
//    }



    /**
     * visit function for BooleanLiteral
     */
    public boolean visit(BooleanLiteral node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for BreakStatement
     */
    public boolean visit(BreakStatement node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for CastExpression
     */
    public boolean visit(CastExpression node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for CatchClause
     */
    public boolean visit(CatchClause node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for CharacterLiteral
     */
    public boolean visit(CharacterLiteral node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for ClassInstanceCreation
     */
    public boolean visit(ClassInstanceCreation node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for CompilationUnit
     */
//    public boolean visit(CompilationUnit node) {
//        nodes.add(node);
//        return true;
//    }


    /**
     * visit function for ContinueStatement
     */
    public boolean visit(ContinueStatement node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for DoStatement
     */
    public boolean visit(DoStatement node) {
        nodes.add(node);
        return true;
    }


/*** visit function for EmptyStatement
 */
public boolean visit(EmptyStatement node) {
    nodes.add(node);
    return true;
}


    /**
     * visit function for EnhancedForStatement
     */
    public boolean visit(EnhancedForStatement node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for EnumConstantDeclaration
     */
    public boolean visit(EnumConstantDeclaration node) {
        nodes.add(node);
        return true;
    }

    /**
     * visit function for ExpressionStatement
     */
    public boolean visit(ExpressionStatement node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for FieldAccess
     */
    public boolean visit(FieldAccess node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for FieldDeclaration
     */
    public boolean visit(FieldDeclaration node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for ForStatement
     */
    public boolean visit(ForStatement node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for IfStatement
     */
    public boolean visit(IfStatement node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for ImportDeclaration
     */
    public boolean visit(ImportDeclaration node) {
        //nodes.add(node);
        return true;
    }


    /**
     * visit function for InfixExpression
     */
    public boolean visit(InfixExpression node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for Initializer
     */
    public boolean visit(Initializer node) {
        nodes.add(node);
        return true;
    }



    /**
     * visit function for Javadoc
     */
    public boolean visit(Javadoc node) {
        //nodes.add(node);
        return true;
    }



    /**
     * visit function for MarkerAnnotation
     */
    public boolean visit(MarkerAnnotation node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for MemberValuePair
     */
    public boolean visit(MemberValuePair node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for MethodDeclaration
     */
    public boolean visit(MethodDeclaration node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for MethodInvocation
     */
    public boolean visit(MethodInvocation node) {
        nodes.add(node);
        return true;
    }


    /**
     * visit function for SimpleName
     */
    public boolean visit(SimpleName name) {
        nodes.add(name);
        return true;
    }


    /**
     * visit function for NumberLiteral type node
     */
    public boolean visit(NumberLiteral num) {
        nodes.add(num);
        return true;
    }

     /**
     * visit function for TypeDeclaration type node
     */
    public boolean visit(TypeDeclaration t) {
    		return true;
    }
    
     /**
     * visit function for WhileStatement type node
     */
    public boolean visit(WhileStatement s) {
    	nodes.add(s);
    	return true;
    }

}
