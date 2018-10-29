import React from 'react';
import App from './App';
import { mount } from 'enzyme';

describe('<App />', () => {
  it('displays stations from the station store', () => {
    const component = mount(<App />);
    expect(component.find('[data-station]').first().text()).toContain('Grand Central')
  });
});
