import React from 'react';
import { mount } from 'enzyme';
import App from './App';

describe('<App />', () => {
  it('displays stations from the station store', () => {
    const component = mount(<App />);
    expect(component.find('[data-station]').first().text()).toContain('Grand Central');
  });
});
