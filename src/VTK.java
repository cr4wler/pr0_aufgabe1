import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class VTK {
	private String prefix;
	private int frame, frames;
	
	public VTK(String prefix, int frames) {
		this.frames = frames;
		this.prefix = prefix;
		this.frame = 0;
	}
	
	public void writeFrame(Field field) {
		if (this.frame >= this.frames) {
			return;
		}
		
		String filename = generateFilename();
		FileOutputStream fh;
		try {
			fh = new FileOutputStream(filename);
			writeHeader(fh, field);
			writeBody(fh, field);
			fh.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.frame++;
	}
	
	public int getFrames() {
		return this.frames;
	}
	
	public int getFrame() {
		return this.frame;
	}
	
	private void writeHeader(FileOutputStream fh, Field field) throws IOException {
		BufferedWriter writer;
		writer = new BufferedWriter(new OutputStreamWriter(fh, "utf-8"));
		writer.write("# vtk DataFile Version 3.0");
		writer.newLine();
		writer.write("Mandelbrot pr0grammierkurs Frame " + this.frame + " von " + (this.frames - 1));
		writer.newLine();
		writer.write("BINARY");
		writer.newLine();
		writer.write("DATASET STRUCTURED_POINTS");
		writer.newLine();
		writer.write("DIMENSIONS " + field.getSizeInDim(0) + " " + field.getSizeInDim(1) + " 1");
		writer.newLine();
		writer.write("SPACING 1.0 1.0 1.0");
		writer.newLine();
		writer.write("ORIGIN 0 0 0");
		writer.newLine();
		writer.write("POINT_DATA " + (field.getSizeInDim(0) * field.getSizeInDim(1)));
		writer.newLine();
		writer.write("SCALARS data int 1");
		writer.newLine();
		writer.write("LOOKUP_TABLE default");
		writer.newLine();
		writer.flush();

	}
	
	private void writeBody(FileOutputStream fh, Field field) throws IOException {
		int x_size = field.getSizeInDim(0);
		int y_size = field.getSizeInDim(1);
		int size = x_size * y_size;
		
		DataOutputStream ds = new DataOutputStream(fh);
		
		for (int i = 0; i < size; i++) {
			ds.writeInt(field.getCell(i % x_size, i / x_size));
		}
		fh.flush();
	}
	
	private String generateFilename() {
		String padding = "";
		
		for (int i = Integer.toString(frame).length() ; i <= 5; i++) {
			padding += "0";
		}
		return prefix + "-" + padding + frame + ".vtk";
	}
}
