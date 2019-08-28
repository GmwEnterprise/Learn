<template>
  <div id="customize-datetime-picker">
    <div class="c-d-p-title">
      <span class="c-d-p-btn">&lt;</span>
      <span>2019-07-24</span>
      <span class="c-d-p-btn">&gt;</span>
    </div>
    <table class="c-d-p-content">
      <thead>
        <tr>
          <th>日</th>
          <th>一</th>
          <th>二</th>
          <th>三</th>
          <th>四</th>
          <th>五</th>
          <th>六</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>2</td>
          <td>3</td>
          <td>4</td>
          <td>5</td>
          <td>6</td>
          <td>7</td>
        </tr>
        <tr>
          <td>8</td>
          <td>9</td>
          <td>10</td>
          <td>11</td>
          <td>12</td>
          <td>13</td>
          <td>14</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: 'CustomizeDateTimePicker',
  props: {
    dateValue: {
      type: Date,
      default: () => new Date(2019, 8 - 1, 4)
    }
  },
  computed: {},
  methods: {
    clickTd() {

    },
    dateInit() {
      const year = this.dateValue.getFullYear()
      const month = (this.dateValue.getMonth() + 1) + '' // 0 ~ 11
      const dayOfMonth = this.dateValue.getDate() + '' // 1 ~ 31
      const dayOfWeek = this.dateValue.getDay() // 0 ~ 6
      console.log(`${year}-${month.padStart(2, '0')}-${dayOfMonth.padStart(2, '0')}, ${dayOfWeek}`)
    }
  },
  mounted() {
    this.dateInit()
  }
}
</script>

<style>
#customize-datetime-picker {
  width: 16rem;
  height: auto;
  min-height: 16rem;
  background-color: white;
  box-shadow: 0px 0px 10px 0px #cecece;
  border-radius: 5px;
  margin: 0 auto;
}
.c-d-p-title {
  display: flex;
  justify-content: space-between;
  height: 2em;
  line-height: 2em;
  padding: 10px;
  box-sizing: content-box;
  background-color: lightgray;
}
.c-d-p-btn {
  width: 2em;
  text-align: center;
  cursor: pointer;
}
.c-d-p-content {
  width: 96%;
  margin: 0.3rem auto;
  text-align: center;
  line-height: 2em;
  color: #4e4e4e;
}
.c-d-p-content td {
  transition: 0.2s;
  cursor: pointer;
}
.c-d-p-content td:hover {
  color: white;
  background-color: lightgray;
}
</style>