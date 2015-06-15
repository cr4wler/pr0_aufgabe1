
public class Field {
	
	private int[] sizes;
	private int[] field;
	
	public Field(int size_x, int size_y) {
		this.sizes = new int[] {size_x, size_y};
		this.field = new int[size_x * size_y];
	}
	
	public int getCell(int x, int y) {
		return this.field[x + this.sizes[0] * y];
	}
	
	public void setCell(int x, int y, int value) {
		this.field[x + this.sizes[0] * y] = value;
	}
	public int getSizeInDim(int dim) {
		return this.sizes[dim];
	}
}
