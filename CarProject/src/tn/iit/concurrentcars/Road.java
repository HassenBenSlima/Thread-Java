package tn.iit.concurrentcars;

public class Road {
	/**
	 * tous les carffours
	 **/
	private RoundPoint rp1;
	private RoundPoint rp2;
	private RoundPoint rp3;
	private RoundPoint rp4;
	private RoundPoint rp5;
	private RoundPoint rp6;
	private RoundPoint rp7;
	private RoundPoint rp8;
	private RoundPoint rp9;
	
	private InTheRoundPoint irp1;
	private InTheRoundPoint irp2;
	private InTheRoundPoint irp3;
	private InTheRoundPoint irp4;
	private InTheRoundPoint irp5;
	private InTheRoundPoint irp6;
	private InTheRoundPoint irp7;
	private InTheRoundPoint irp8;
	private InTheRoundPoint irp9;

	public void createRectInTheRoundPoint() {
		irp1 = new InTheRoundPoint(new Point(18, 18), null, new Point(75, 75), null);
		irp2 = new InTheRoundPoint(new Point(277, 18), new Point(337, 18), new Point(337, 75), new Point(277, 75));
		irp3 = new InTheRoundPoint(null, new Point(597, 18), null, new Point(537, 75));
		irp4 = new InTheRoundPoint(new Point(18, 277), new Point(75, 277), new Point(75, 337), new Point(18, 377));
		irp5 = new InTheRoundPoint(new Point(277, 277), new Point(337, 277), new Point(337, 337), new Point(277, 337));
		irp6 = new InTheRoundPoint(new Point(537, 277), new Point(597, 277), new Point(597, 337), new Point(537, 337));
		irp7 = new InTheRoundPoint(new Point(18, 537), new Point(75, 537), new Point(75, 597), new Point(18, 597));
		irp8 = new InTheRoundPoint(new Point(277, 537), new Point(337, 537), new Point(337, 597), new Point(277, 597));
		irp9 = new InTheRoundPoint(new Point(537, 537), new Point(597, 537), new Point(597, 597), new Point(537, 597));
	}

	public void setIrp1(InTheRoundPoint irp1) {
		this.irp1 = irp1;
	}

	public void setIrp2(InTheRoundPoint irp2) {
		this.irp2 = irp2;
	}

	public void setIrp3(InTheRoundPoint irp3) {
		this.irp3 = irp3;
	}

	public void setIrp4(InTheRoundPoint irp4) {
		this.irp4 = irp4;
	}

	public void setIrp5(InTheRoundPoint irp5) {
		this.irp5 = irp5;
	}

	public void setIrp6(InTheRoundPoint irp6) {
		this.irp6 = irp6;
	}

	public void setIrp7(InTheRoundPoint irp7) {
		this.irp7 = irp7;
	}

	public void setIrp8(InTheRoundPoint irp8) {
		this.irp8 = irp8;
	}

	public void setIrp9(InTheRoundPoint irp9) {
		this.irp9 = irp9;
	}

	public InTheRoundPoint getIrp1() {
		return irp1;
	}

	public InTheRoundPoint getIrp2() {
		return irp2;
	}

	public InTheRoundPoint getIrp3() {
		return irp3;
	}

	public InTheRoundPoint getIrp4() {
		return irp4;
	}

	public InTheRoundPoint getIrp5() {
		return irp5;
	}

	public InTheRoundPoint getIrp6() {
		return irp6;
	}

	public InTheRoundPoint getIrp7() {
		return irp7;
	}

	public InTheRoundPoint getIrp8() {
		return irp8;
	}

	public InTheRoundPoint getIrp9() {
		return irp9;
	}

	public RoundPoint getRp1() {
		return rp1;
	}

	public void setRp1(RoundPoint rp1) {
		this.rp1 = rp1;
	}

	public RoundPoint getRp2() {
		return rp2;
	}

	public void setRp2(RoundPoint rp2) {
		this.rp2 = rp2;
	}

	public RoundPoint getRp3() {
		return rp3;
	}

	public void setRp3(RoundPoint rp3) {
		this.rp3 = rp3;
	}

	public RoundPoint getRp4() {
		return rp4;
	}

	public void setRp4(RoundPoint rp4) {
		this.rp4 = rp4;
	}

	public RoundPoint getRp5() {
		return rp5;
	}

	public void setRp5(RoundPoint rp5) {
		this.rp5 = rp5;
	}

	public RoundPoint getRp6() {
		return rp6;
	}

	public void setRp6(RoundPoint rp6) {
		this.rp6 = rp6;
	}

	public RoundPoint getRp7() {
		return rp7;
	}

	public void setRp7(RoundPoint rp7) {
		this.rp7 = rp7;
	}

	public RoundPoint getRp8() {
		return rp8;
	}

	public void setRp8(RoundPoint rp8) {
		this.rp8 = rp8;
	}

	public RoundPoint getRp9() {
		return rp9;
	}

	public void setRp9(RoundPoint rp9) {
		this.rp9 = rp9;
	}

	public void createRoundPoints() {
		rp1 = new RoundPoint(new Point(110, 18), null, null, new Point(75, 110), irp1);

		rp2 = new RoundPoint(new Point(370, 18), null, new Point(260, 75), new Point(337, 110), irp2);

		rp3 = new RoundPoint(null, null, new Point(520, 75), new Point(597, 110), irp3);

		rp4 = new RoundPoint(new Point(110, 277), new Point(18, 260), null, new Point(75, 370), irp4);

		rp5 = new RoundPoint(new Point(370, 277), new Point(277, 260), new Point(260, 337), new Point(337, 370), irp5);

		rp6 = new RoundPoint(null, new Point(537, 260), new Point(520, 337), new Point(597, 370), irp6);

		rp7 = new RoundPoint(new Point(110, 537), new Point(18, 520), null, null, irp7);

		rp8 = new RoundPoint(new Point(370, 537), new Point(277, 520), new Point(260, 597), null, irp8);

		rp9 = new RoundPoint(null, new Point(537, 520), new Point(520, 597), null, irp9);

	}

}
