Hmwk5.class : Hmwk5.java Background.class
	javac Hmwk5.java

Background.class : Background.java ShapeIO.class CircleDialog.class EquilateralDialog.class SquareDialog.class RectangleDialog.class RightDialog.class ScaleneDialog.class
	javac Background.java

Circle.class : Circle.java
	javac Circle.java

Equilateral.class : Equilateral.java Triangle.class
	javac Equilateral.java

Quadrilateral.class : Quadrilateral.java Shape.class
	javac Quadrilateral.java

Rectangle.class : Rectangle.java Quadrilateral.class
	javac Rectangle.java

Right.class : Right.java Triangle.class
	javac Right.java

Scalene.class : Scalene.java Triangle.class
	javac Scalene.java

ShapeIO.class : ShapeIO.java Circle.class Equilateral.class Rectangle.class Right.class Scalene.class Square.class
	javac ShapeIO.java

Shape.class : Shape.java
	javac Shape.java

Square.class : Square.java Quadrilateral.class
	javac Square.java

Triangle.class : Triangle.java Shape.class
	javac Triangle.java

ScaleneDialog.class: ScaleneDialog.java ColorPanel.class
	javac ScaleneDialog.java

RightDialog.class: RightDialog.java ColorPanel.class
	javac RightDialog.java

RectangleDialog.class: RectangleDialog.java ColorPanel.class
	javac RectangleDialog.java

SquareDialog.class: SquareDialog.java ColorPanel.class
	javac SquareDialog.java

CircleDialog.class : CircleDialog.java ColorPanel.class
	javac CircleDialog.java

EquilateralDialog.class : EquilateralDialog.java ColorPanel.class
	javac EquilateralDialog.java

ShapeDialog.class : ShapeDialog.java
	javac ShapeDialog.java

ColorPanel.class : ColorPanel.java
	javac ColorPanel.java

clean :
	rm *.class
