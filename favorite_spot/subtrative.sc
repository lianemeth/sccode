s.boot;

b = Buffer.read(s, "/home/lucas/sccode/favorite_spot/input.wav");
{PlayBuf.ar(1, b.bufnum, BufRateScale.kr(b.bufnum))}.scope;
(
{Resonz.ar(
	PlayBuf.ar(1, b.bufnum, BufRateScale.kr(b.bufnum))
	,XLine.kr(220,8000,10),
	1
)}.scope
)
s.quit;
