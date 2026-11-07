const AC_GMAE_OBJECTS = []

export class AcGameObject {
  constructor() {
    AC_GMAE_OBJECTS.push(this);
    this.timedelta = 0;
    this.has_called_start = false;
  }

  start() { // 只执行一次
    
  }

  update() { // 每一帧执行一次，除了第一帧以外
    
  }

  on_destory() { // 删除之前执行
    
  }


  destroy() {
    this.on_destory();
    
    for (let i in AC_GMAE_OBJECTS) {
      const obj = AC_GMAE_OBJECTS[i];
      if (obj === this) {
        AC_GMAE_OBJECTS.splice(i);
        break;
      }
    }
  }
}


let last_timestamp; // 上一次执行的时刻
const step = timestamp => {
  for (let obj of AC_GMAE_OBJECTS) {
    if (!obj.has_called_start) {
      obj.has_called_start = true;
      obj.start();
    } else {
      obj.timedelta = timestamp - last_timestamp;
      obj.update();
    }
  }

  last_timestamp = timestamp
  requestAnimationFrame(step);
}

requestAnimationFrame(step);