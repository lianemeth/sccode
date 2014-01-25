s.boot;
s.quit;
(
 SynthDef(\borboleta, {|out = 0, freq, amp, dur, pan = 0, mod = 50|
  
  var pm, modulator, env, panner;
  
  modulator = SinOsc.ar(freq, 0, 0.5);
  pm = LFSaw.ar(modulator,0 ,mod);
  
  env = EnvGen.kr(Env.triangle(1.0, dur), doneAction:2);
  panner = Pan2.ar(pm, pan, env);
  
  Out.ar(out, panner);
 }).store
)


(
 a = Pbind(
  \instrument, \borboleta,
  \freq,  Pseq([ 1, 2, 5/4, 3/2, 16/9, 9/8, 2 , 3/2, 5/4 ] * 440, inf),
  \dur, Prand([0.1,0.2,0.03,0.2,0.4,0.8],inf),
  \mod,  110,
  \pan, 1
 ).play
)
a.stop;
(
 b = Pbind(
  \instrument, \borboleta,
  \freq,  Pseq([ 1, 2, 5/4, 3/2, 16/9, 9/8, 2 , 3/2, 5/4 ] * 150, inf),
  \dur, Prand([0.1,0.02,0.3,0.2,0.04,0.8],inf),
  \mod,  110,
  \pan, 0
 ).play
)
b.stop;
(
 c = Pbind(
  \instrument, \borboleta,
  \freq,  Prand([ 1, 2, 5/4, 3/2, 16/9, 9/8, 2 , 3/2, 5/4 ] * 955, inf),
  \dur, Prand([0.2,0.4,0.8],inf),
  \mod,  550,
  \pan, 0
 ).play
)
c.stop;
(
 d = Pbind(
  \instrument, \borboleta,
  \freq,  Prand([ 1, 2, 5/4, 3/2, 16/9, 9/8, 2 , 3/2, 5/4 ] * 210, inf),
  \dur, Prand([0.2,0.4,0.8],inf),
  \mod,  220,
  \pan, 1
 ).play
)
d.stop;

