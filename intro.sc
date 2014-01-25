s.boot;
//intro for "insects" perfomance

//first
{ BPF.ar(BrownNoise.ar(0.1.dup), MouseX.kr(17000, 400, -1), MouseY.kr(0.01,0.1,0.01 )) }.play;

//second
{ PinkNoise.ar(MouseY.kr(0.01,0.1))}.play;

//third
{
	s = SinOsc.ar(
			LFSaw.kr(
			SinOsc.kr(
				MouseX.kr(0.01,5),
				MouseX.kr(10,20),
				MouseY.kr(10,20),0.3,0.9),
				0, 
				MouseX.kr(100,400),
				MouseY.kr(50,200)),
				0.3,
				0.9
			)*0.02;            
	//returns as stereo
	[s,s]
}.play
