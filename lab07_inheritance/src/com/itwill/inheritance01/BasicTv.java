package com.itwill.inheritance01;
//extends Object는 생략가능
public class BasicTv {
	// 상수 정의
	public static final int MIN_CHANNEL = 0;
	public static final int MAX_CHANNEL = 2;

	public static final int MIN_VOLUME = 0;
	public static final int MAX_VOLUME = 2;
	
	// 필드 초기화 안해도 알아서 되어잇음/
	private boolean powerOn; // 전원 상태 (true = ON, false = OFF)
	private int channel; // 현재 채널 번호
	private int volume; // 음량

	// 생성자
	public BasicTv() {
	}

	public BasicTv(boolean powerOn, int channel, int volume) {
		this.powerOn = powerOn;
		this.channel = channel;
		this.volume = volume;
	}
	//getter, setter
	public boolean isPowerOn() {
		return powerOn;
	}

	public void setPowerOn(boolean powerOn) {
		this.powerOn = powerOn;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	// 메서드
	/**
	 * TV가 켜져 있으면 끄고, TV가 꺼져 있으면 킨다
	 *  powerOn의 값이 true이면 false로 변경, powerOn의 값이 false면 true로 변경
	 * @return PowerOn의 값
	 */
	public boolean powerOnOff() {
		// switch는 boolean type 쓸 수 없음. 하면 안댐!!
		if (powerOn) { //이걸 굳이 (powerOn == true)로 안 쓰고. (powerOn)이케 쓰면 됨!!!! true이면 첫번째 false이면 두번째 실행되겟지!!
			powerOn = false;
			System.out.println("TV OFF");
		} else {
			powerOn=true;
			System.out.println("TV ON");
		}
		return powerOn;
	}

	/**
	 * channelUp. 현재 채널의 값을 1 증가
	 * 만약 현재 채널이 채널의 최댓값(MAX_CHANNEL)인 경우, 채널의 최솟값(MIN_CHANNEL)으로 변경.
	 * @return 바뀐 현재 채널의 값
	 */
	
	public int channelUp() {
		if (powerOn) { //TV가 켜져있을 때!!
			if (channel<MAX_CHANNEL) {
				channel ++;
			} else {
				channel = MIN_CHANNEL;
			}
			System.out.println("CH : "+channel);
		}
		return channel;
	}
	
	/**
	 * channelUp. 현재 채널의 값을 1 감소
	 * 만약 현재 채널이 채널의 최솟값(MIN_CHANNEL)인 경우, 채널의 최댓값(MAX_CHANNEL)으로 변경.
	 * @return 바뀐 현재 채널의 값
	 */
	public int channelDown() {
		if (powerOn) { //TV가 켜져있을 때!!
			if (channel > MIN_CHANNEL) {
				channel--;
			} else {
				channel = MAX_CHANNEL;
			}
		System.out.println("CH : "+channel);
		}
		return channel;
	}
	
	/**
	 * volumeUp. 현재 음량의 값을 1 증가
	 * 만약 현재 음량이 음량의 최댓값(MAX_VOLUME)인 경우, 음량을 변경하지 않음.
	 * @return 바뀐 현재 음량 값.
	 */
	public int volumeUp() {
		if (powerOn) { //TV가 켜져있을 때!!
			if (volume<MAX_VOLUME) {
				volume ++;
			}
		System.out.println("VOL : "+volume);
		}
		return volume;
	}
	
	
	/**
	 * volumeDown. 현재 음량의 값을 1 감소
	 * 만약 현재 음량이 음량의 최솟값(MIN_VOLUME)인 경우, 음량을 변경하지 않음.
	 * @return 바뀐 현재 음량 값.
	 */
	public int volumeDown() {
		if (powerOn) { //TV가 켜져있을 때!!
			if (volume > MIN_VOLUME) {
				volume--;
			} 
		System.out.println("VOL : "+volume);
		}
		return volume;
	}

}
