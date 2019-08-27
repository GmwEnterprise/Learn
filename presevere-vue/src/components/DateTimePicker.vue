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
          <td></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: 'CustomizeDateTimePicker',
  props: {
    datetime: Date
  },
  computed: {
    dateObject() {
    }
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
</style>